package com.github.fabriciolfj.conta.domain.integracao.producer.dto


data class LimiteCacheDTO(var saque: String, var valor: String) {

    constructor(): this("", "")
}