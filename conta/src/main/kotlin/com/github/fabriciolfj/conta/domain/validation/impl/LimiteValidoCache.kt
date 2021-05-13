package com.github.fabriciolfj.conta.domain.validation.impl

import com.github.fabriciolfj.conta.api.exceptions.LimiteValorExcedidoException
import com.github.fabriciolfj.conta.domain.integracao.cache.LimiteCacheIntegracao
import com.github.fabriciolfj.conta.domain.validation.MovimentacaoValidation
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class LimiteValidoCache : MovimentacaoValidation {

    private var logger = LoggerFactory.getLogger(LimiteValidoCache::class.java)

    @Autowired
    private lateinit var limiteCache: LimiteCacheIntegracao

    override fun executar(valor: BigDecimal, conta: String) {
        val cache = limiteCache.getCache(conta)

        if (valor > cache.limite) {
            throw LimiteValorExcedidoException("Valor de saque excedido. Valor: $valor Limite: ${cache.limite} Conta: $conta" )
        }
    }
}