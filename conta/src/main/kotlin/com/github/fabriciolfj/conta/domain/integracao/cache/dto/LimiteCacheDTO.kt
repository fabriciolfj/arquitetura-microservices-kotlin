package com.github.fabriciolfj.conta.domain.integracao.cache.dto

import java.math.BigDecimal

data class LimiteCacheDTO(var limite: BigDecimal, var qtdSaque: Int) {

    constructor() : this( BigDecimal.ZERO, 0)
}