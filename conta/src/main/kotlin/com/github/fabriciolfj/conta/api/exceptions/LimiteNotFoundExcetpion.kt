package com.github.fabriciolfj.conta.api.exceptions

import java.lang.RuntimeException

class LimiteNotFoundExcetpion: RuntimeException {

    constructor(msg: String) : super(msg)
}