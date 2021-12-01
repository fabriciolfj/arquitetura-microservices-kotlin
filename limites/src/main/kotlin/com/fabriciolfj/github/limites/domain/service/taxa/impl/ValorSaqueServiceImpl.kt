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
class ValorSaqueServiceImpl : RegraTaxaService {

    private val logger = LoggerFactory.getLogger(ValorSaqueServiceImpl::class.java)

    override fun execute(usos: List<LimiteUsoDiario>, valor: BigDecimal, limite: Limite): Boolean {
        var month = YearMonth.from(LocalDate.now())
        var totalUso = usos
            .filter { it.data.isAfter(month.atDay(1)) && it.data.isBefore(month.atEndOfMonth()) }
            .sumOf { it.valor }

        logger.info("limite: ${limite.valorDiario}, uso: $totalUso")
        var total = totalUso.add(valor)
        return total > limite.valorDiario
    }
}