package com.fabriciolfj.github.limites.domain.integracao.cache.dto

import java.math.BigDecimal

data class LimiteCacheDTO(var saque: Int, var valor: BigDecimal) {

    constructor(): this( 0, BigDecimal.ZERO)
}