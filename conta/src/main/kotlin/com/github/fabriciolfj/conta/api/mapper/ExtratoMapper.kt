package com.github.fabriciolfj.conta.api.mapper

import com.github.fabriciolfj.conta.domain.entity.Conta
import com.github.fabriciolfj.conta.domain.entity.Extrato
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.LocalDateTime

@Component
class ExtratoMapper {

    fun toEntity(saldo: BigDecimal, conta: Conta) = Extrato(null, conta, LocalDateTime.now(), saldo)
}