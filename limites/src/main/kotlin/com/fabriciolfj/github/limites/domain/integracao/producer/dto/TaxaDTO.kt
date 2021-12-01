package com.fabriciolfj.github.limites.domain.integracao.producer.dto

import java.math.BigDecimal

data class TaxaDTO(var taxa: BigDecimal, var conta: String) {

    constructor() : this(BigDecimal.ZERO, "")
}