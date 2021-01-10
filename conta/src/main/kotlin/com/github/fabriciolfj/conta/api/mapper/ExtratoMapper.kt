package com.github.fabriciolfj.conta.api.mapper

import com.github.fabriciolfj.conta.domain.entity.Conta
import com.github.fabriciolfj.conta.domain.entity.Extrato
import com.github.fabriciolfj.conta.domain.entity.TipoTransacao
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.LocalDateTime

@Component
class ExtratoMapper {

    fun toEntity(saldo: BigDecimal, conta: Conta) = Extrato(null, conta, LocalDateTime.now(), TipoTransacao.ABERTURA, saldo)

    fun toEntity(extratoOld: Extrato, debito : BigDecimal, operacao: TipoTransacao) : Extrato {
        var newValue = extratoOld.saldo.subtract(debito)
        return Extrato(null, extratoOld.conta, LocalDateTime.now(), operacao, newValue)
    }
}