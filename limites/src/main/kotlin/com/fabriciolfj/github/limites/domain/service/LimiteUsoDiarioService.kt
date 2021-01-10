package com.fabriciolfj.github.limites.domain.service

import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.AtualizarContaDTO
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO
import com.fabriciolfj.github.limites.domain.integracao.entity.LimiteUsoDiarioMapper
import com.fabriciolfj.github.limites.domain.repository.LimiteUsoDiarioRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LimiteUsoDiarioService {

    val logger = LoggerFactory.getLogger(LimiteUsoDiarioService::class.java)

    @Autowired
    private lateinit var limiteUsoDiarioRepository: LimiteUsoDiarioRepository

    @Autowired
    private lateinit var limiteUsoDiarioMapper: LimiteUsoDiarioMapper

    @Autowired
    private lateinit var limiteService: LimiteService

    fun create(usoContaDTO: UsoContaDTO) {
        val limite = limiteService.findByLimite(usoContaDTO.conta)

        if (!limite.isPresent) {
            logger.info("Limite nao encontrado, criando um novo")
            return
        }

        process(usoContaDTO, limite.get())
        logger.info("Salvo o limite diario com sucesso")
    }

    fun process(usoContaDTO: UsoContaDTO, limite: Limite) {
        var uso = limiteUsoDiarioMapper.toEntity(usoContaDTO, limite)
        limiteUsoDiarioRepository.save(uso)
    }
}