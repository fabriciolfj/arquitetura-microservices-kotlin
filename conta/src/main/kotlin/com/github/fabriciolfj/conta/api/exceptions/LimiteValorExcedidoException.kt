package com.github.fabriciolfj.conta.api.exceptions

import java.lang.RuntimeException

class LimiteValorExcedidoException: RuntimeException {

    constructor(msg: String) : super(msg)
}