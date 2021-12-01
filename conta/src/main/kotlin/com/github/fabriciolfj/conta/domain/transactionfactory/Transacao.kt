package com.github.fabriciolfj.conta.domain.transactionfactory

import com.github.fabriciolfj.conta.domain.integracao.producer.dto.UsoContaDTO

interface Transacao {

    fun execute(usoContaDTO: UsoContaDTO)
}