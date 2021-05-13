package com.fabriciolfj.github.limites.domain.integracao.cache

import com.fabriciolfj.github.limites.api.exceptions.LimiteUsoUpdateException
import com.fabriciolfj.github.limites.domain.integracao.cache.dto.LimiteCacheDTO
import com.fabriciolfj.github.limites.infrastructure.ConfigCache.Companion.CACHE_NAME
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.Cache
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.util.*
import java.util.Optional.ofNullable

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

    fun updateValor(conta: String, valor: BigDecimal) {
        var value = cache.get(conta)
        ofNullable(value)
            .map { it.get() as LimiteCacheDTO }
            .map {
                it.limite = it.limite.subtract(valor)
            }
            .map { cache.put(conta, it) }
            .orElseThrow { throw LimiteUsoUpdateException("Falha ao atualizar o uso do limite no cache. Conta $conta e valor $valor") }
    }
}