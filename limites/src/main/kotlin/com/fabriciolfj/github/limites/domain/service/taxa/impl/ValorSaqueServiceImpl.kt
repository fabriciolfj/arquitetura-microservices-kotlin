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
        //implementar
        return true
    }
}