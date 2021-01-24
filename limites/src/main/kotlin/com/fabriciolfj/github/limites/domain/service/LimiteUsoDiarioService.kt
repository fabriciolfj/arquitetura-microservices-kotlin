package com.fabriciolfj.github.limites.domain.service

import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO
import com.fabriciolfj.github.limites.domain.integracao.entity.LimiteUsoDiarioMapper
import com.fabriciolfj.github.limites.domain.integracao.producer.CobraTaxaProducer
import com.fabriciolfj.github.limites.domain.integracao.producer.dto.TaxaDTO
import com.fabriciolfj.github.limites.domain.repository.LimiteUsoDiarioRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate
import java.time.YearMonth

@Service
class LimiteUsoDiarioService {

    val logger = LoggerFactory.getLogger(LimiteUsoDiarioService::class.java)

    @Autowired
    private lateinit var limiteUsoDiarioRepository: LimiteUsoDiarioRepository
    @Autowired
    private lateinit var limiteUsoDiarioMapper: LimiteUsoDiarioMapper
    @Autowired
    private lateinit var limiteService: LimiteService
    @Autowired
    private lateinit var cobraTaxaProducer: CobraTaxaProducer

    fun create(usoContaDTO: UsoContaDTO) {
        val limite = limiteService.findByLimite(usoContaDTO.conta)

        if (!limite.isPresent) {
            logger.info("Limite nao encontrado, para conta ${usoContaDTO.conta}")
            return
        }

        process(usoContaDTO, limite.get())
        logger.info("Salvo o limite diario com sucesso")
    }

    private fun process(usoContaDTO: UsoContaDTO, limite: Limite) {
        if (isCobrarTaxa(limite, usoContaDTO.valor)) {
            cobraTaxaProducer.process(TaxaDTO(BigDecimal.valueOf(1.78), usoContaDTO.conta))
        }

        salvar(usoContaDTO, limite)
    }

    private fun isCobrarTaxa(limite: Limite, valor: BigDecimal) : Boolean {
        var usos = limiteUsoDiarioRepository.findByLimiteOrderByDataDesc(limite.id)
        return isValorSaqueMesUltrapassado(usos, valor, limite) || isQuantidadeSaqueUltrapassado(usos, limite)
    }

    private fun isQuantidadeSaqueUltrapassado(usos: List<LimiteUsoDiario>, limite: Limite): Boolean {
        var totalUso = usos.filter { it.data.isEqual(LocalDate.now()) }
            .count() + 1

        var result = totalUso > limite.quantidadeSaqueMensal
        logger.info("Ultrapassou o limite de uso de quantidade saque: $result, total uso: $totalUso, limite: ${limite.quantidadeSaqueMensal}")
        return result
    }

    private fun isValorSaqueMesUltrapassado(usos: List<LimiteUsoDiario>, valor: BigDecimal, limite: Limite): Boolean {
        var month = YearMonth.from(LocalDate.now())
        var totalUso = usos
            .filter { it.data.isAfter(month.atDay(1)) && it.data.isBefore(month.atEndOfMonth()) }
            .sumOf { it.valor }

        logger.info("limite: ${limite.valorDiario}, uso: $totalUso")
        var total = totalUso.add(valor)
        return total > limite.valorDiario
    }

    private fun salvar(usoContaDTO: UsoContaDTO, limite: Limite) {
        var uso = limiteUsoDiarioMapper.toEntity(usoContaDTO, limite.id)
        limiteUsoDiarioRepository.save(uso)
    }
}