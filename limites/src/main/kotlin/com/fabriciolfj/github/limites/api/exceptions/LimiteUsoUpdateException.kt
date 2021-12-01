package com.fabriciolfj.github.limites.api.exceptions

import java.lang.RuntimeException

class LimiteUsoUpdateException : RuntimeException {

    constructor(msg: String) : super(msg)
}