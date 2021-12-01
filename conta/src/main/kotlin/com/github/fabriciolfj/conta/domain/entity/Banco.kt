package com.github.fabriciolfj.conta.domain.entity

import javax.persistence.*

@Entity
@Table(name = "banco")
data class Banco (@Id
                  @GeneratedValue(strategy = GenerationType.IDENTITY)
                  val id: Long,
                  val code: String,
                  val descricao: String,
                  @OneToMany(mappedBy = "banco")
                  val contas: List<Conta>)