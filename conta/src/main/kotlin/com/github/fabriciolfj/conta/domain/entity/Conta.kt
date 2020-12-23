package com.github.fabriciolfj.conta.domain.entity

import javax.persistence.*

@Entity
@Table(name = "CONTA")
data class Conta(@Id
                 @Column(name = "id")
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                 val id: Long,
                 @Column(name = "numero")
                 val numero: Int,
                 @Column(name = "digito")
                 val digito: Int,
                 @Column(name = "banco")
                 val banco: Int,
                 @Column(name = "cliente")
                 val cliente: String)