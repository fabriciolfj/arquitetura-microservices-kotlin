package com.github.fabriciolfj.conta.domain.service

import com.github.fabriciolfj.conta.api.exceptions.ExtratoNotFoundException
import com.github.fabriciolfj.conta.api.mapper.ExtratoMapper
import com.github.fabriciolfj.conta.api.mapper.request.OperacaoRequest
import com.github.fabriciolfj.conta.domain.entity.Conta
import com.github.fabriciolfj.conta.domain.entity.TipoTransacao
import com.github.fabriciolfj.conta.domain.integracao.producer.dto.UsoContaDTO
import com.github.fabriciolfj.conta.domain.repository.ExtratoRepository
import com.github.fabriciolfj.conta.domain.transactionfactory.Transacao
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
class OperacaoService {

    private var logger = LoggerFactory.getLogger(OperacaoService::class.java)

    @Autowired
    private lateinit var extratoRepository: ExtratoRepository

    @Autowired
    private lateinit var extratoMapper: ExtratoMapper

    @Autowired
    private lateinit var transacoes: List<Transacao>

    @Transactional("chainedKafkaTransactionManager")
    fun executarOperacao(request: OperacaoRequest, conta: String) {
        var tipo = TipoTransacao.toEnum(request.tipo)
        getUltimoExtratoECriaNovo(conta, request.valor, tipo).map {
                val usoContaDTO = UsoContaDTO(conta, tipo.descricao, request.valor, it.data.toString())
                executarTransacoes(usoContaDTO)
                extratoRepository.save(it)
            }
            .orElseThrow { throw ExtratoNotFoundException("Extrato nao encontrado para conta $conta") }
    }

    @Transactional("chainedKafkaTransactionManager")
    fun updateChequeEspecial(conta: Conta, valor: BigDecimal) {
        extratoRepository.findByContaAndOperacao(conta, TipoTransacao.CHEQUEESPECIAL)
            .map {
                it.valor = valor
            }.orElseGet {
                updateValorUltimoExtrato(conta.numero, valor, TipoTransacao.CHEQUEESPECIAL)
            }
    }

    @Transactional("chainedKafkaTransactionManager")
    fun updateValorUltimoExtrato(conta: String, valor: BigDecimal, tipo: TipoTransacao) {
        getUltimoExtratoECriaNovo(conta, valor, tipo)
            .map {
                logger.info("Atualizando o extrato: $it")
                extratoRepository.save(it)
            }
    }

    private fun getUltimoExtratoECriaNovo(conta: String, valor: BigDecimal, tipo: TipoTransacao) =
        extratoRepository.findByLastExtrato(conta)
            .map {
                logger.info("Ultimo extrato: $it")
                extratoMapper.toEntity(it, valor, tipo)
            }

    private fun executarTransacoes(usoContaDTO: UsoContaDTO) {
        transacoes.forEach { it.execute(usoContaDTO) }
    }
}