package com.fabriciolfj.github.limites.domain.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDate

@Document(collection = "limiteUsoDiario")
data class LimiteUsoDiario(@Id val id: String?, val limite: String, val transacao: String, val valor: BigDecimal, val data: LocalDate) {

    constructor(): this("", "","", BigDecimal.ZERO, LocalDate.now())
}