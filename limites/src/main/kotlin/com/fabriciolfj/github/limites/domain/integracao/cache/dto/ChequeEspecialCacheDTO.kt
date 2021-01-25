package com.fabriciolfj.github.limites.domain.integracao.cache.dto

import java.math.BigDecimal

data class ChequeEspecialCacheDTO(var valor: BigDecimal) {

    constructor(): this(BigDecimal.ZERO)
}