package com.fabriciolfj.github.limites.domain.document

import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document(collation = "limites")
class Limite (@Indexed val id: String, val conta: String, val valorDiario: BigDecimal, val quantidadeSaqueDiario: Int)