package com.fabriciolfj.github.limites.domain.repository

import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario
import org.springframework.data.mongodb.repository.MongoRepository

interface LimiteUsoDiarioRepository :MongoRepository<LimiteUsoDiario, String> {

    fun findByLimiteOrderByDataDesc(limite: String) : List<LimiteUsoDiario>
}