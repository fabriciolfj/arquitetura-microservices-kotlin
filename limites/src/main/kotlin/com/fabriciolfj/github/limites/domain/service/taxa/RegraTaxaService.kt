package com.fabriciolfj.github.limites.domain.service.taxa

import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario
import java.math.BigDecimal

interface RegraTaxaService {

    fun execute(usos: List<LimiteUsoDiario>, limite: Limite) : Boolean
}