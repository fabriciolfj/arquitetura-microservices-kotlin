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

    fun resetValorSaqueDiario(conta: String, valor: BigDecimal) {
        ofNullable(getCache(conta))
            .map {
                it.limite = valor
                cache.put(conta, it)
            }.orElseThrow {
                throw LimiteUsoUpdateException("Falha ao resetar o limite diario. Conta: $conta, Valor: $valor")
            }
    }

    fun updateUsoValor(conta: String, valor: BigDecimal) {
        ofNullable(getCache(conta) )
            .map {
                it.limite = it.limite.subtract(valor)
            }
            .map { cache.put(conta, it) }
            .orElseThrow { throw LimiteUsoUpdateException("Falha ao atualizar o uso do limite no cache. Conta $conta e valor $valor") }
    }

    private fun getCache(conta: String) : LimiteCacheDTO {
        return ofNullable(cache.get(conta))
            .map { it.get() as LimiteCacheDTO }
            .orElseThrow { throw LimiteUsoUpdateException("Falha ao atualizar o uso do limite no cache. Conta $conta") }
    }
}