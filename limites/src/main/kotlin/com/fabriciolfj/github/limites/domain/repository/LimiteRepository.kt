package com.fabriciolfj.github.limites.domain.repository

import com.fabriciolfj.github.limites.domain.document.Limite
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface LimiteRepository : MongoRepository<Limite, String> {

    fun findByContaComDigito(conta: String) : Optional<Limite>

}