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
    fun bathDiario() {
        var (initPage, limites) = getLimitePageInit()

        while (limites.totalPages >= initPage) {
            executeReset(limites.content)

            val pair = getProximoLimitePage(limites, initPage)
            initPage = pair.first
            limites = pair.second
        }
    }
    
    @Scheduled(cron = "30 9 15 * ?", zone = "America/Sao_Paulo")
    fun batchMensal() {
        var (initPage, limites) = getLimitePageInit()

        while (limites.totalPages >= initPage) {
            execute(limites.content)

            val pair = getProximoLimitePage(limites, initPage)
            initPage = pair.first
            limites = pair.second
        }
    }

    private fun getProximoLimitePage(limites: Page<Limite>, initPage: Int): Pair<Int, Page<Limite>> {
        var limiteReturn = limites
        var initPageReturn = initPage

        if (limiteReturn.totalPages >= initPageReturn) {
            initPageReturn++
            var page = PageRequest.of(initPageReturn, SIZE)
            limiteReturn = limiteService.findAll(page)
        }

        return Pair(initPageReturn, limiteReturn)
    }

    private fun getLimitePageInit(): Pair<Int, Page<Limite>> {
        var initPage = 1
        var page = PageRequest.of(initPage, SIZE)

        var limites = limiteService.findAll(page)
        return Pair(initPage, limites)
    }

    private fun execute(limites: List<Limite>) {
        limites
            .stream()
            .forEach {
                logger.info("limite: $it")
                atualizarCache.process(it.contaComDigito, it.valorDiario, it.quantidadeSaqueMensal)
            }
    }

    private fun executeReset(limites: List<Limite>) {
        limites
            .stream()
            .forEach {
                logger.info("limite: $it")
                atualizarCache.resetValorSaqueDiario(it.contaComDigito, it.valorDiario)
            }
    }
}