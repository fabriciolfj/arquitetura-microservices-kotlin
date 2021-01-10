package com.github.fabriciolfj.conta.api.mapper.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
data class ContaRequest(val numero: String, val cliente: String, val saldo: BigDecimal) {

    constructor() : this("", "", BigDecimal.ZERO)
}