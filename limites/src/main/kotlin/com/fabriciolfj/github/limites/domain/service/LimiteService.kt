package com.fabriciolfj.github.limites.domain.service

import com.fabriciolfj.github.limites.api.dto.LimiteResponse
import com.fabriciolfj.github.limites.api.mapper.LimiteMapper
import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.repository.LimiteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class LimiteService {

    @Autowired
    lateinit var limiteRepository: LimiteRepository

    @Autowired
    lateinit var limiteMapper: LimiteMapper

    fun create(limite: Limite) {
        limiteRepository.save(limite)
    }

    fun findByLimite(conta: String): LimiteResponse {
        return limiteRepository.findByConta(conta)
                .map { limiteMapper.toResponse(it) }
                .orElseThrow { RuntimeException("Limite nao encontrado para conta $conta") }

    }
}