package com.fabriciolfj.github.limites.api.dto

import java.math.BigDecimal

data class LimiteResponse(var saque: Int, var valor: BigDecimal) {

    constructor() : this(0, BigDecimal.ZERO)
}