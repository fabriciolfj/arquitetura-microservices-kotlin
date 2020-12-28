package com.github.fabriciolfj.conta.api.mapper.request

import com.github.fabriciolfj.conta.domain.entity.Conta
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component


@Component
class ContaRequestMapper {

    private var logger = LoggerFactory.getLogger(ContaRequestMapper::class.java)

    fun toEntity(request: ContaRequest) : Conta {
        return Conta(null, request.numero, request.digito, null, request.cliente)
    }
}