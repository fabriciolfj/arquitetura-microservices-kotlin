package com.fabriciolfj.github.limites.domain.integracao.entity.impl

import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario
import com.fabriciolfj.github.limites.domain.document.TipoTransacao
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO
import com.fabriciolfj.github.limites.domain.integracao.entity.LimiteUsoDiarioMapper
import java.time.LocalDate
import java.time.format.DateTimeFormatter

abstract class LimiteUsoDiarioMapperDecorated : LimiteUsoDiarioMapper {

    override fun toEntity(usoContaDTO: UsoContaDTO, limite: Limite) : LimiteUsoDiario {
        var simpleDate = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        var data = LocalDate.parse(usoContaDTO.data, simpleDate)
        return LimiteUsoDiario(
            null,
            limite,
            TipoTransacao.toDescricao(usoContaDTO.tipo),
            usoContaDTO.valor,
            data
        )
    }

}
