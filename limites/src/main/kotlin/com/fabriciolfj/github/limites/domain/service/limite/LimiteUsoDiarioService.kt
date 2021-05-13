package com.fabriciolfj.github.limites.domain.service.limite

import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario
import com.fabriciolfj.github.limites.domain.integracao.cache.AtualizarCache
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO
import com.fabriciolfj.github.limites.domain.integracao.entity.LimiteUsoDiarioMapper
import com.fabriciolfj.github.limites.domain.repository.LimiteUsoDiarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class LimiteUsoDiarioService {

    @Autowired
    private lateinit var limiteUsoDiarioRepository: LimiteUsoDiarioRepository
    @Autowired
    private lateinit var limiteUsoDiarioMapper: LimiteUsoDiarioMapper
    @Autowired
    private lateinit var atualizarCache: AtualizarCache

    fun salvar(usoContaDTO: UsoContaDTO, limite: Limite) {
        var uso = limiteUsoDiarioMapper.toEntity(usoContaDTO, limite.id!!)
        limiteUsoDiarioRepository.save(uso)
    }

    fun findUsosByLimite(id: String) : List<LimiteUsoDiario> {
        return limiteUsoDiarioRepository.findByLimiteOrderByDataDesc(id)
    }

    fun atualizarLimiteNoCache(conta: String, valor: BigDecimal) {
        atualizarCache.updateValor(conta, valor)
    }
}