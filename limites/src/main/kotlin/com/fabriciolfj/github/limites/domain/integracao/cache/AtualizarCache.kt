package com.fabriciolfj.github.limites.domain.integracao.cache

import com.fabriciolfj.github.limites.domain.integracao.cache.dto.LimiteCacheDTO
import com.fabriciolfj.github.limites.infrastructure.ConfigCache.Companion.CACHE_NAME
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.Cache
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class AtualizarCache {

    private var logger = LoggerFactory.getLogger(AtualizarCache::class.java)

    @Autowired
    @Qualifier(CACHE_NAME)
    private lateinit var cache: Cache

    fun process(conta: String, valor: BigDecimal, qtdSaque: Int) {
        logger.info("Atualizando o cache.")
        var limiteDto = LimiteCacheDTO(valor, qtdSaque)
        cache.put(conta, limiteDto)
    }
}