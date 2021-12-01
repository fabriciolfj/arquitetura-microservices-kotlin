package com.fabriciolfj.github.limites.domain.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document(collection = "limites")
data class Limite (@Id var id: String,
                   var contaComDigito: String,
                   var valorDiario: BigDecimal,
                   var quantidadeSaqueMensal: Int) {

    constructor() : this("0", "0", BigDecimal.ZERO, 0)
}