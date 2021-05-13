package com.fabriciolfj.github.limites.domain.integracao.entity;

import java.lang.System;

@org.mapstruct.DecoratedWith(value = com.fabriciolfj.github.limites.domain.integracao.entity.impl.LimiteUsoDiarioMapperDecorated.class)
@org.mapstruct.Mapper(componentModel = "spring")
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/fabriciolfj/github/limites/domain/integracao/entity/LimiteUsoDiarioMapper;", "", "toEntity", "Lcom/fabriciolfj/github/limites/domain/document/LimiteUsoDiario;", "usoContaDTO", "Lcom/fabriciolfj/github/limites/domain/integracao/consumer/dto/UsoContaDTO;", "limite", "", "limites"})
public abstract interface LimiteUsoDiarioMapper {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario toEntity(@org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO usoContaDTO, @org.jetbrains.annotations.NotNull()
    java.lang.String limite);
}