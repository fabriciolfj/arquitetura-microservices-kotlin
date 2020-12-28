package com.github.fabriciolfj.conta.api.exceptions

import java.lang.RuntimeException

class BancoNotFoundException(msg: String) : RuntimeException(msg)