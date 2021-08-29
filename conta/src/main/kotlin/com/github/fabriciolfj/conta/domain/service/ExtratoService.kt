package com.github.fabriciolfj.conta.domain.service

import com.github.fabriciolfj.conta.api.mapper.ExtratoMapper
import com.github.fabriciolfj.conta.domain.entity.Extrato
import com.github.fabriciolfj.conta.domain.entity.TipoTransacao
import com.github.fabriciolfj.conta.domain.repository.ExtratoRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.util.*

@Service
class ExtratoService {

    @Autowired
    private lateinit var extratoRepository: ExtratoRepository

    @Autowired
    private lateinit var extratoMapper: ExtratoMapper

    val logger = LoggerFactory.getLogger(ExtratoService::class.java)

    @Transactional("chainedKafkaTransactionManager")
    fun saveExtrato(extrato: Extrato) {
        extratoRepository.save(extrato)
    }

    @Transactional("chainedKafkaTransactionManager")
    fun updateValorUltimoExtrato(conta: String, valor: BigDecimal, tipo: TipoTransacao) {
        criarExtrato(conta, valor, tipo)
            .map {
                logger.info("Atualizando o extrato: $it")
                extratoRepository.save(it)
            }
    }

    fun criarExtrato(conta: String, valor: BigDecimal, tipo: TipoTransacao): Optional<Extrato> =
        extratoRepository.findByLastExtrato(conta)
            .map {
                logger.info("Ultimo extrato: $it")
                extratoMapper.toEntity(it, valor, tipo)
            }
}