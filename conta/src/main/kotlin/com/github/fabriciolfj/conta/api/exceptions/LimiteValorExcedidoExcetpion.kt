package com.github.fabriciolfj.conta.api.exceptions

import java.lang.RuntimeException

class LimiteValorExcedidoExcetpion: RuntimeException {

    constructor(msg: String) : super(msg)
}