package com.github.fabriciolfj.conta.api.mapper

import com.github.fabriciolfj.conta.api.mapper.request.ContaRequest
import com.github.fabriciolfj.conta.api.mapper.response.ContaResponse
import com.github.fabriciolfj.conta.domain.entity.Conta
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component


@Component
class ContaMapper {

    private var logger = LoggerFactory.getLogger(ContaMapper::class.java)

    fun toEntity(request: ContaRequest) : Conta {
        return Conta(null, request.numero, request.digito, null, request.cliente, emptyList())
    }

    fun toResponse(conta: Conta) : ContaResponse {
        return ContaResponse(conta.numero, conta.digito, conta.cliente, conta.banco!!.code)
    }
}