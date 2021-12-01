package com.github.fabriciolfj.conta.domain.integracao.cache

import com.github.fabriciolfj.conta.domain.entity.Conta
import com.github.fabriciolfj.conta.domain.integracao.cache.dto.ChequeEspecialCacheDTO
import com.github.fabriciolfj.conta.domain.service.ContaService
import com.github.fabriciolfj.conta.domain.service.OperacaoService
import com.github.fabriciolfj.conta.infrastructure.ConfigCache.Companion.CACHE_NAME
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.Cache
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.*

@Component
class ChequeEspecialScheduler {

    private var logger = LoggerFactory.getLogger(ChequeEspecialScheduler::class.java)

    @Autowired
    @Qualifier(CACHE_NAME)
    private lateinit var cache: Cache
    @Autowired
    private lateinit var operacaoService: OperacaoService
    @Autowired
    private lateinit var contaService: ContaService

    @Scheduled(fixedDelay = 5000)
    fun gravarChequeEspecial() {
        contaService.findAll()
            .forEach { gerarExtrato(it) }
    }

    private fun gerarExtrato(conta: Conta) {
        Optional.ofNullable(cache.get(conta.numero))
            .map {
                it.get() as ChequeEspecialCacheDTO
            }.map {
                logger.info("Cheque especial encontrado: ${it.valor}")
                operacaoService.updateChequeEspecial(conta, it.valor)
            }
    }
}