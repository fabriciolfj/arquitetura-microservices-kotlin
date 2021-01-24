package com.github.fabriciolfj.conta.domain.integracao.producer.dto

import java.math.BigDecimal

data class UsoContaDTO(val conta: String, val tipo: String, val valor: BigDecimal, val data: String) {

    constructor() : this("", "", BigDecimal.ZERO, "")
}