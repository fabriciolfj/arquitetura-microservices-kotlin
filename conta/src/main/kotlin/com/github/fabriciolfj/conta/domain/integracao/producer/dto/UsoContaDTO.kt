package com.github.fabriciolfj.conta.domain.integracao.producer.dto

import com.github.fabriciolfj.conta.domain.integracao.producer.MessageDTO
import java.math.BigDecimal

data class UsoContaDTO(val conta: String, val tipo: String, val valor: BigDecimal, val data: String) : MessageDTO {

    constructor() : this("", "", BigDecimal.ZERO, "")
}