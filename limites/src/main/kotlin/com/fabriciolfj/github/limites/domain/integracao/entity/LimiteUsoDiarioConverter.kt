package com.fabriciolfj.github.limites.domain.integracao.entity

import com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario
import com.fabriciolfj.github.limites.domain.document.TipoTransacao
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LimiteUsoDiarioConverter {

    companion object {

        fun toEntity(usoContaDTO: UsoContaDTO, limite: String) : LimiteUsoDiario {
            var simpleDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            var dataLimite = LocalDateTime.parse(usoContaDTO.data.format(simpleDate))
            return LimiteUsoDiario(
                null,
                limite,
                TipoTransacao.toDescricao(usoContaDTO.tipo),
                usoContaDTO.valor,
                dataLimite.toLocalDate()
            )
        }
    }
}