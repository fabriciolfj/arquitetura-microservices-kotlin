package com.github.fabriciolfj.conta.api.mapper.response

import com.github.fabriciolfj.conta.domain.entity.Conta
import org.springframework.stereotype.Component


@Component
class ContaResponseMapper {

    fun toResponse(conta: Conta) : ContaResponse {
        return ContaResponse(conta.numero, conta.digito, conta.cliente, conta.banco!!.code)
    }
}