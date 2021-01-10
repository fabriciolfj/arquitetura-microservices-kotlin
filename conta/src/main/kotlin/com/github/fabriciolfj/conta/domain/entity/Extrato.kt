package com.github.fabriciolfj.conta.domain.entity

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "extrato")
data class Extrato (
                    @Id
                    @GeneratedValue(strategy = GenerationType.IDENTITY)
                    val id: Long?,
                    @JoinColumn(name = "conta_id")
                    @ManyToOne
                    val conta: Conta?,
                    val data: LocalDateTime,
                    val saldo: BigDecimal) {
    constructor() : this(0, null, LocalDateTime.now(), BigDecimal.ZERO)
}