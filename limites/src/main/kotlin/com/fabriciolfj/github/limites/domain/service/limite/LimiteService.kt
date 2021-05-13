package com.fabriciolfj.github.limites.domain.service.limite

import com.fabriciolfj.github.limites.api.dto.LimiteRequest
import com.fabriciolfj.github.limites.api.dto.LimiteResponse
import com.fabriciolfj.github.limites.api.mapper.LimiteMapper
import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.AtualizarContaDTO
import com.fabriciolfj.github.limites.domain.repository.LimiteRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class LimiteService {

    @Autowired
    private lateinit var limiteRepository: LimiteRepository

    @Autowired
    private lateinit var limiteMapper: LimiteMapper

    val logger = LoggerFactory.getLogger(LimiteService::class.java)

    fun findAll(page: Pageable): Page<Limite> {
        return limiteRepository.findAll(page)
    }

    fun create(limite: LimiteRequest) =
        limiteMapper.toEntity(limite)
            .apply { limiteRepository.save(this) }

    fun create(atualizarContaDTO: AtualizarContaDTO) {
        findByLimite(atualizarContaDTO.conta)
            .map {
                limiteMapper.merge(atualizarContaDTO, it)
            }.orElseGet {
                limiteMapper.toEntity(atualizarContaDTO)
                    .apply {
                        logger.info("Salvando o limite: $this")
                        limiteRepository.save(this)
                    }
            }
    }

    fun findByLimiteResponse(conta: String): LimiteResponse {
        return this.findByLimite(conta)
            .map { limiteMapper.toResponse(it) }
            .orElseThrow { RuntimeException("Limite nao encontrado para conta $conta") }
    }

    fun findByLimite(conta: String) : Optional<Limite> {
        var limite = limiteRepository.findByContaComDigito(conta);
        return limite;
    }
}