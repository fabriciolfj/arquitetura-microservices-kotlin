package com.fabriciolfj.github.limites.domain.service.taxa.impl

import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario
import com.fabriciolfj.github.limites.domain.service.taxa.RegraTaxaService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate
import java.time.YearMonth

@Service
class QuantidadeSaqueServiceImpl : RegraTaxaService {

    val logger = LoggerFactory.getLogger(QuantidadeSaqueServiceImpl::class.java)

    override fun execute(usos: List<LimiteUsoDiario>, limite: Limite): Boolean {
        var month = YearMonth.from(LocalDate.now())
        var totalUso = usos
            .filter { it.data.isAfter(month.atDay(1)) && it.data.isBefore(month.atEndOfMonth()) }
            .count()

        logger.info("limite: ${limite.quantidadeSaqueMensal}, uso: $totalUso")
        return totalUso > limite.quantidadeSaqueMensal
    }
}