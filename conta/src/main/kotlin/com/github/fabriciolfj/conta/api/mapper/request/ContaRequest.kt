package com.github.fabriciolfj.conta.api.mapper.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Positive

@JsonIgnoreProperties(ignoreUnknown = true)
data class ContaRequest(
    @field:NotBlank(message = "numero da conta deve ser informado")
    val numero: String,
    @field:Pattern(regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})")
    @field:NotBlank(message = "cpf do cliente deve ser informado")
    val cliente: String,
    @field:NotNull(message = "saldo inicial deve ser informado")
    @field:Positive(message = "saldo inicial deve ser informado")
    val saldo: BigDecimal) {

    constructor() : this("", "", BigDecimal.ZERO)
}