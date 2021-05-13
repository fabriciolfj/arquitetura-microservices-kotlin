package com.github.fabriciolfj.conta.api.exceptions

import java.lang.RuntimeException

class ValorInvalidoException: RuntimeException {

    constructor(msg: String) : super(msg)
}