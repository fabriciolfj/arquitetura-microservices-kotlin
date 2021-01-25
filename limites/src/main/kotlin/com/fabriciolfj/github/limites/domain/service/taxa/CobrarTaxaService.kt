package com.fabriciolfj.github.limites.domain.service.taxa

import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO
import com.fabriciolfj.github.limites.domain.integracao.producer.CobraTaxaProducer
import com.fabriciolfj.github.limites.domain.integracao.producer.dto.TaxaDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class CobrarTaxaService {

    @Autowired
    private lateinit var regras: List<RegraTaxaService>

    @Autowired
    private lateinit var cobraTaxaProducer: CobraTaxaProducer

    fun execute(limite: Limite, usoContaDTO: UsoContaDTO, usos: List<LimiteUsoDiario>) {
        if (regras.filter { it.execute(usos, usoContaDTO.valor, limite) }.isNotEmpty()) cobraTaxaProducer.process(
            TaxaDTO(BigDecimal.valueOf(1.78), usoContaDTO.conta)
        )
    }
}