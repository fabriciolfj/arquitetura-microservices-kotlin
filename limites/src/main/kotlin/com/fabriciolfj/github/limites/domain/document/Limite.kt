package com.fabriciolfj.github.limites.domain.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document(collection = "limites")
data class Limite (@Id var id: String,
                   var contaComDigito: String,
                   var valorDiario: BigDecimal,
                   var quantidadeSaqueMensal: Int,
                   @DBRef var uso: List<LimiteUsoDiario>) {

    constructor() : this("0", "0", BigDecimal.ZERO, 0, emptyList())
}