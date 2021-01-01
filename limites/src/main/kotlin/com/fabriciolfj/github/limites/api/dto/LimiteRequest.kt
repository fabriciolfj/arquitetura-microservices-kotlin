package com.fabriciolfj.github.limites.api.dto

import java.math.BigDecimal

data class LimiteRequest(var conta: String, var volumeSaque: Int, var valorDiario: BigDecimal) {

    constructor() : this("", 0, BigDecimal.ZERO)
}