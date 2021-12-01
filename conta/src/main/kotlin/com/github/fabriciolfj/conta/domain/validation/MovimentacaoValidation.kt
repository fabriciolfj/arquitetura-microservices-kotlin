package com.github.fabriciolfj.conta.domain.validation

import java.math.BigDecimal

interface MovimentacaoValidation {

    fun executar(valor: BigDecimal, conta: String)
}