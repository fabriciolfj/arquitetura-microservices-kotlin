package com.github.fabriciolfj.conta.api.mapper.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
data class OperacaoRequest(val tipo: String, val valor: BigDecimal) {

    constructor() : this("", BigDecimal.ZERO)
}