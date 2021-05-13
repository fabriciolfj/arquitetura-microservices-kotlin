package com.github.fabriciolfj.conta.domain.integracao.cache

import com.github.fabriciolfj.conta.domain.integracao.cache.dto.LimiteCacheDTO
import com.github.fabriciolfj.conta.infrastructure.ConfigCache
import com.github.fabriciolfj.conta.infrastructure.ConfigCache.Companion.CACHE_NAME
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.Cache
import org.springframework.stereotype.Component
import java.util.*

@Component
class LimiteCacheIntegracao {

    @Autowired
    @Qualifier(CACHE_NAME)
    private lateinit var cache : Cache

    fun getCache(conta: String): LimiteCacheDTO {
        val value = cache.get(conta)
        return Optional.ofNullable(value)
            .map { it.get() as LimiteCacheDTO }
            .orElseGet { LimiteCacheDTO() }
    }
}