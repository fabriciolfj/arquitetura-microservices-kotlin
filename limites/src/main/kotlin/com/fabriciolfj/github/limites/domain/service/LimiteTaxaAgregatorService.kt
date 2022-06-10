package com.fabriciolfj.github.limites.domain.service

import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO
import com.fabriciolfj.github.limites.domain.service.limite.LimiteService
import com.fabriciolfj.github.limites.domain.service.limite.LimiteUsoDiarioService
import com.fabriciolfj.github.limites.domain.service.taxa.CobrarTaxaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LimiteTaxaAgregatorService {

    @Autowired
    lateinit var limiteService: LimiteService
    @Autowired
    lateinit var limiteUsoDiarioService: LimiteUsoDiarioService
    @Autowired
    lateinit var cobrarTaxaService: CobrarTaxaService

    fun execute(usoContaDTO: UsoContaDTO) {
        limiteService.findByLimite(usoContaDTO.conta)
            .map {
                createLimiteUso(usoContaDTO, it)
                executeCobrancataxa(it, usoContaDTO)
            }
    }

    private fun executeCobrancataxa(it: Limite, usoContaDTO: UsoContaDTO) {
        cobrarTaxaService.execute(it, usoContaDTO, limiteUsoDiarioService.findUsosByLimite(it.id!!))
    }

    private fun createLimiteUso(usoContaDTO: UsoContaDTO, it: Limite) {
        limiteUsoDiarioService.salvar(usoContaDTO, it)
    }


}