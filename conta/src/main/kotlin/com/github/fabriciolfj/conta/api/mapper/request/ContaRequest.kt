package com.github.fabriciolfj.conta.api.mapper.request

import java.math.BigDecimal

data class ContaRequest(val numero: String, val digito: Int, val cliente: String, val saldo: BigDecimal) {

    constructor() : this("", 0, "", BigDecimal.ZERO)
}