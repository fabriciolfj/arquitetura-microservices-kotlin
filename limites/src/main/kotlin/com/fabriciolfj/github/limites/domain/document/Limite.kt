package com.fabriciolfj.github.limites.domain.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document(collation = "limites")
data class Limite (@Id val id: String,
                   val contaComDigito: String,
                   val valorDiario: BigDecimal,
                   val quantidadeSaqueDiario: Int,
                   @DBRef val uso: List<LimiteUsoDiario>)