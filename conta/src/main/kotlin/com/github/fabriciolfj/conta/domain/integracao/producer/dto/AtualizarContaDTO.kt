package com.github.fabriciolfj.conta.domain.integracao.producer.dto

import java.math.BigDecimal

data class AtualizarContaDTO(var conta: String, var qtdSaqueMensal: Int, var valorDiario: BigDecimal, var data: String) {

    constructor() : this("", 0, BigDecimal.ZERO, "")
}