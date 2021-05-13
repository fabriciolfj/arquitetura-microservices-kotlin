package com.github.fabriciolfj.conta.api.exceptions

import java.lang.RuntimeException

class LimiteNotFoundException: RuntimeException {

    constructor(msg: String) : super(msg)
}