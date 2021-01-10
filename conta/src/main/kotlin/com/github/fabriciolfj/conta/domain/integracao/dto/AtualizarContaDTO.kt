package com.github.fabriciolfj.conta.domain.integracao.dto

import java.math.BigDecimal
import java.time.LocalDate

data class AtualizarContaDTO(var conta: String, var qtdSaqueMensal: Int, var valorDiario: BigDecimal, var data: LocalDate?) {

    constructor() : this("", 0, BigDecimal.ZERO, null)
}