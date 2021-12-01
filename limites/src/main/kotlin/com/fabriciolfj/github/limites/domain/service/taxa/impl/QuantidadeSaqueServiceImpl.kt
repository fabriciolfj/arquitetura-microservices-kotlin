package com.fabriciolfj.github.limites.domain.service.taxa.impl

import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario
import com.fabriciolfj.github.limites.domain.service.taxa.RegraTaxaService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate

@Service
class QuantidadeSaqueServiceImpl : RegraTaxaService {

    override fun execute(usos: List<LimiteUsoDiario>, valor: BigDecimal, limite: Limite): Boolean {
        var totalUso = usos.filter { it.data.isEqual(LocalDate.now()) }
            .count() + 1

        return totalUso > limite.quantidadeSaqueMensal
    }
}