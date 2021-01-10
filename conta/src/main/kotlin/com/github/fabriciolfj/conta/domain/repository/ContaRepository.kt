package com.github.fabriciolfj.conta.domain.repository

import com.github.fabriciolfj.conta.domain.entity.Conta
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ContaRepository: JpaRepository<Conta, Long> {

    fun findByNumero(conta: String) : Optional<Conta>
}