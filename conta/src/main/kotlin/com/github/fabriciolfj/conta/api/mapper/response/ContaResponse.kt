package com.github.fabriciolfj.conta.api.mapper.response


data class ContaResponse (val numero: String, val digito: Int, val cliente: String, var banco: String)