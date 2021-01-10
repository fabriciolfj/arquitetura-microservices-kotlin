package com.github.fabriciolfj.conta.api.mapper

import com.github.fabriciolfj.conta.api.mapper.request.LimiteRequest
import com.github.fabriciolfj.conta.domain.integracao.dto.AtualizarContaDTO
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Component
class AtualizarContaMapper {

    fun toDto(limite: LimiteRequest, conta: String) :AtualizarContaDTO {
        var dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return AtualizarContaDTO(conta, limite.saque!!, limite.valor!!, dateFormat.format(LocalDate.now()))
    }
}