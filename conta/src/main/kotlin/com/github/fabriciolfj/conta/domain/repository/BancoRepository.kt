package com.github.fabriciolfj.conta.domain.repository

import com.github.fabriciolfj.conta.domain.entity.Banco
import org.springframework.data.jpa.repository.JpaRepository

interface BancoRepository : JpaRepository<Banco, Long> {

    fun findByCode(code: String) : Banco?
}