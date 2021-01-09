package com.github.fabriciolfj.conta.domain.integracao.dto

import java.math.BigDecimal

data class AtualizarContaDTO(var conta: String, var volumeSaque: Int, var valorDiario: BigDecimal) {
    
    constructor() : this("", 0, BigDecimal.ZERO)
}