package com.github.fabriciolfj.conta.domain.service

import com.github.fabriciolfj.conta.api.exceptions.ExtratoNotFoundException
import com.github.fabriciolfj.conta.api.mapper.request.OperacaoRequest
import com.github.fabriciolfj.conta.domain.entity.Extrato
import com.github.fabriciolfj.conta.domain.entity.TipoTransacao
import com.github.fabriciolfj.conta.domain.integracao.producer.dto.UsoContaDTO
import com.github.fabriciolfj.conta.domain.transactionfactory.Transacao
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OperacaoService {

    private var logger = LoggerFactory.getLogger(OperacaoService::class.java)

    @Autowired
    private lateinit var extratoService: ExtratoService

    @Autowired
    private lateinit var transacoes: List<Transacao>

    @Transactional("chainedKafkaTransactionManager")
    fun executarOperacao(request: OperacaoRequest, conta: String) {
        var tipo = TipoTransacao.toEnum(request.tipo)
        extratoService.getUltimoExtratoECriaNovo(conta, request.valor, tipo).map {
                val usoContaDTO = usoContaDTO(conta, tipo, request, it)
                executarTransacoes(usoContaDTO)
                extratoService.saveExtrato(it)
            }
            .orElseThrow { throw ExtratoNotFoundException("Extrato nao encontrado para conta $conta") }
    }

    private fun executarTransacoes(usoContaDTO: UsoContaDTO) {
        transacoes.forEach { it.execute(usoContaDTO) }
    }

    private fun usoContaDTO(
        conta: String,
        tipo: TipoTransacao,
        request: OperacaoRequest,
        it: Extrato
    ): UsoContaDTO {
        return UsoContaDTO(conta, tipo.descricao, request.valor, it.data.toString())
    }
}