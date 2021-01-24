package com.fabriciolfj.github.limites.api.exceptions

import java.lang.RuntimeException

class LimiteValorExcedidoException : RuntimeException {

    constructor(msg: String) : super(msg)
}