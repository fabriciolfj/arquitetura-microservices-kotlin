package com.github.fabriciolfj.conta.api.exceptions

import java.lang.RuntimeException

class ValorInvalidoExcetpion: RuntimeException {

    constructor(msg: String) : super(msg)
}