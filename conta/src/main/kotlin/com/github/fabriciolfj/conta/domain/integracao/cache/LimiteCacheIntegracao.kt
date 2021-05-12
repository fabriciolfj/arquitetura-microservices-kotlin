package com.github.fabriciolfj.conta.domain.integracao.cache

import com.github.fabriciolfj.conta.api.exceptions.LimiteValorExcedidoExcetpion
import com.github.fabriciolfj.conta.domain.integracao.cache.dto.LimiteCacheDTO
import com.github.fabriciolfj.conta.domain.integracao.producer.dto.UsoContaDTO
import com.github.fabriciolfj.conta.domain.transactionfactory.Transacao
import com.github.fabriciolfj.conta.domain.validation.MovimentacaoValidation
import com.github.fabriciolfj.conta.infrastructure.ConfigCache.Companion.CACHE_NAME
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.Cache
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.util.Optional.ofNullable

@Component
class LimiteCacheIntegracao : MovimentacaoValidation {

    private var logger = LoggerFactory.getLogger(LimiteCacheIntegracao::class.java)

    @Autowired
    @Qualifier(CACHE_NAME)
    private lateinit var cache: Cache

    override fun executar(valor: BigDecimal, conta: String) {
        val cache = getCache(conta)

        if (cache.limite == BigDecimal.ZERO && valor > cache.limite) {
            throw LimiteValorExcedidoExcetpion("Valor de saque excedido. Valor: $valor Limite: ${cache.limite} Conta: $conta" )
        }
    }

    private fun getCache(conta: String): LimiteCacheDTO {
        val value = cache.get(conta)
        return ofNullable(value)
            .map { it.get() as LimiteCacheDTO }
            .orElseGet { LimiteCacheDTO() }
    }
}