package com.github.fabriciolfj.conta.domain.integracao.consumer.dto

import java.math.BigDecimal

data class TaxaDTO(var taxa: BigDecimal, var conta: String) {

    constructor() : this(BigDecimal.ZERO, "")
}