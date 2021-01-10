package com.github.fabriciolfj.conta.domain.integracao.dto

import java.math.BigDecimal

data class LimiteCacheDTO(val saque: Int, val valor: BigDecimal) {

    constructor(): this(0, BigDecimal.ZERO)
}