package com.fabriciolfj.github.limites.domain.integracao.entity

import com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO
import com.fabriciolfj.github.limites.domain.integracao.entity.impl.LimiteUsoDiarioMapperDecorated
import org.mapstruct.DecoratedWith
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
@DecoratedWith(LimiteUsoDiarioMapperDecorated::class)
interface LimiteUsoDiarioMapper {

    fun toEntity(usoContaDTO: UsoContaDTO, limite: String) : LimiteUsoDiario
}