package com.github.fabriciolfj.conta.api.mapper.request

import java.math.BigDecimal
import javax.validation.constraints.NotNull

data class LimiteRequest(@NotNull var saque: Int?, @NotNull var valor: BigDecimal?) {

    constructor() : this(0, BigDecimal.ZERO)
}