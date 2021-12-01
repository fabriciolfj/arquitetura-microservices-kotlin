package com.fabriciolfj.github.limites.domain.service.limite

import com.fabriciolfj.github.limites.api.dto.LimiteRequest
import com.fabriciolfj.github.limites.api.dto.LimiteResponse
import com.fabriciolfj.github.limites.api.mapper.LimiteMapper
import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.AtualizarContaDTO
import com.fabriciolfj.github.limites.domain.repository.LimiteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class LimiteService {

    @Autowired
    private lateinit var limiteRepository: LimiteRepository

    @Autowired
    private lateinit var limiteMapper: LimiteMapper

    fun create(limite: LimiteRequest) =
        limiteMapper.toEntity(limite)
            .apply { limiteRepository.save(this) }

    fun create(atualizarContaDTO: AtualizarContaDTO) =
        limiteMapper.toEntity(atualizarContaDTO)
            .apply { limiteRepository.save(this) }

    fun findByLimiteResponse(conta: String): LimiteResponse {
        return this.findByLimite(conta)
            .map { limiteMapper.toResponse(it) }
            .orElseThrow { RuntimeException("Limite nao encontrado para conta $conta") }
    }

    fun findByLimite(conta: String) : Optional<Limite> {
        return limiteRepository.findByContaComDigito(conta);
    }
}