package com.fabriciolfj.github.limites.domain.integracao.cache

import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.service.limite.LimiteService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class BatchUpdateCache {

    @Autowired
    private lateinit var limiteService: LimiteService
    @Autowired
    private lateinit var atualizarCache: AtualizarCache

    val logger = LoggerFactory.getLogger(BatchUpdateCache::class.java)

    val SIZE = 2

    @Scheduled(cron = "0 53 21 * * ?", zone = "America/Sao_Paulo")
    fun batch() {
        var initPage = 1
        var page = PageRequest.of(initPage, SIZE)
        var limites = limiteService.findAll(page)
        
        while (limites.totalPages >= initPage) {
            execute(limites.content)

            if (limites.totalPages >= initPage) {
                initPage++
                var page = PageRequest.of(initPage, SIZE)
                limites = limiteService.findAll(page)
            }
        }
    }

    private fun execute(limites: List<Limite>) {
        limites
            .stream()
            .forEach {
                logger.info("limite: $it")
                atualizarCache.process(it.contaComDigito, it.valorDiario, it.quantidadeSaqueMensal)
            }
    }
}