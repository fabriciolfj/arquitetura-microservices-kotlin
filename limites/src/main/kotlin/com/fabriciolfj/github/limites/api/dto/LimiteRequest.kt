package com.fabriciolfj.github.limites.api.dto

import java.math.BigDecimal

data class LimiteRequest(val conta: String, val volumeSaque: Int, val valorDiario: BigDecimal) {

    constructor() : this("", 0, BigDecimal.ZERO)
}