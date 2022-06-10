package com.fabriciolfj.github.limites.domain.service.limite

import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO
import com.fabriciolfj.github.limites.domain.integracao.entity.LimiteUsoDiarioConverter
import com.fabriciolfj.github.limites.domain.repository.LimiteUsoDiarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LimiteUsoDiarioService {

    @Autowired
    private lateinit var limiteUsoDiarioRepository: LimiteUsoDiarioRepository

    fun salvar(usoContaDTO: UsoContaDTO, limite: Limite) {
        var uso = LimiteUsoDiarioConverter.toEntity(usoContaDTO, limite.id!!)
        limiteUsoDiarioRepository.save(uso)
    }

    fun findUsosByLimite(id: String) : List<LimiteUsoDiario> {
        return limiteUsoDiarioRepository.findByLimiteOrderByDataDesc(id)
    }
}