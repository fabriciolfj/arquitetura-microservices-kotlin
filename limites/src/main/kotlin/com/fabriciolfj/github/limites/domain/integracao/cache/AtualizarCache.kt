package com.fabriciolfj.github.limites.domain.integracao.cache

import com.fabriciolfj.github.limites.domain.integracao.cache.dto.LimiteCacheMapper
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.AtualizarContaDTO
import com.fabriciolfj.github.limites.infrastructure.ConfigCache.Companion.CACHE_NAME
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.Cache
import org.springframework.stereotype.Component

@Component
class AtualizarCache {

    private var logger = LoggerFactory.getLogger(AtualizarCache::class.java)

    @Autowired
    @Qualifier(CACHE_NAME)
    private lateinit var cache: Cache

    @Autowired
    private lateinit var mapper: ObjectMapper

    @Autowired
    private lateinit var limiteCacheMapper: LimiteCacheMapper

    fun process(atualizarContaDTO: AtualizarContaDTO) {
        logger.info("Atualizando o cache.")
        var limiteCacheDTO = limiteCacheMapper.toDto(atualizarContaDTO)
        var json = mapper.writeValueAsString(limiteCacheDTO)
        cache.put(atualizarContaDTO.conta, json)
    }
}