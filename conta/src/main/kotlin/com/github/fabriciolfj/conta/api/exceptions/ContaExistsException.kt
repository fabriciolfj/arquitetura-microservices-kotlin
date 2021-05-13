package com.github.fabriciolfj.conta.api.exceptions

import java.lang.RuntimeException

class ContaExistsException : RuntimeException {

    constructor(msg: String):  super(msg)
}