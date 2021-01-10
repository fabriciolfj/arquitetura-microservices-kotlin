package com.github.fabriciolfj.conta.api.mapper

import com.github.fabriciolfj.conta.api.mapper.request.LimiteRequest
import com.github.fabriciolfj.conta.domain.integracao.dto.AtualizarContaDTO
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class AtualizarContaMapper {

    fun toDto(limite: LimiteRequest, conta: String) = AtualizarContaDTO(conta, limite.saque!!, limite.valor!!, LocalDate.now())
}