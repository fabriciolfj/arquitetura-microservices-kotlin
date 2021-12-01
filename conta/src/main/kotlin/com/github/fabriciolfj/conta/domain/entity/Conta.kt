package com.github.fabriciolfj.conta.domain.entity

import javax.persistence.*

@Entity
@Table(name = "CONTA")
data class Conta(@Id
                 @Column(name = "id")
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                 val id: Long?,
                 @Column(name = "numero", unique = true)
                 val numero: String,
                 @JoinColumn(name = "banco_id")
                 @ManyToOne
                 var banco: Banco?,
                 @Column(name = "cliente")
                 val cliente: String,
                 @OneToMany(mappedBy = "conta", cascade = [CascadeType.PERSIST, CascadeType.REMOVE])
                 var extratos: List<Extrato>) {

    constructor() : this(0L, "", null, "", emptyList())
}