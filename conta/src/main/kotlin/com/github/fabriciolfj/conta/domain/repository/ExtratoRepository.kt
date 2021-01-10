package com.github.fabriciolfj.conta.domain.repository

import com.github.fabriciolfj.conta.domain.entity.Extrato
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ExtratoRepository : JpaRepository<Extrato, Long> {

    @Query(nativeQuery = true, value = "select * from extrato e \n" +
            " where e.conta_id  = (select id from conta where numero = ?1)\n" +
            "order by data desc \n" +
            "limit 1")
    fun findByLastExtrato(conta: String): Optional<Extrato>
}