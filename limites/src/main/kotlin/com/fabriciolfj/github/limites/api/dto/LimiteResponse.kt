package com.fabriciolfj.github.limites.api.dto

import java.math.BigDecimal

data class LimiteResponse(val saque: Int, val valor: BigDecimal) {

    constructor() : this(0, BigDecimal.ZERO)
}