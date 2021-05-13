package com.fabriciolfj.github.limites.api.mapper;

import java.lang.System;

@org.mapstruct.Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\'\u00a8\u0006\u000e"}, d2 = {"Lcom/fabriciolfj/github/limites/api/mapper/LimiteMapper;", "", "merge", "", "dto", "Lcom/fabriciolfj/github/limites/domain/integracao/consumer/dto/AtualizarContaDTO;", "entity", "Lcom/fabriciolfj/github/limites/domain/document/Limite;", "toEntity", "request", "Lcom/fabriciolfj/github/limites/api/dto/LimiteRequest;", "toResponse", "Lcom/fabriciolfj/github/limites/api/dto/LimiteResponse;", "limite", "limites"})
public abstract interface LimiteMapper {
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "contaComDigito", source = "conta"), @org.mapstruct.Mapping(target = "valorDiario", source = "valorDiario"), @org.mapstruct.Mapping(target = "quantidadeSaqueMensal", source = "volumeSaque")})
    public abstract com.fabriciolfj.github.limites.domain.document.Limite toEntity(@org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.api.dto.LimiteRequest request);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "contaComDigito", source = "conta"), @org.mapstruct.Mapping(target = "valorDiario", source = "valorDiario"), @org.mapstruct.Mapping(target = "quantidadeSaqueMensal", source = "qtdSaqueMensal")})
    public abstract com.fabriciolfj.github.limites.domain.document.Limite toEntity(@org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.integracao.consumer.dto.AtualizarContaDTO dto);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "saque", source = "quantidadeSaqueMensal"), @org.mapstruct.Mapping(target = "valor", source = "valorDiario")})
    public abstract com.fabriciolfj.github.limites.api.dto.LimiteResponse toResponse(@org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.document.Limite limite);
    
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "contaComDigito", source = "conta"), @org.mapstruct.Mapping(target = "valorDiario", source = "valorDiario"), @org.mapstruct.Mapping(target = "quantidadeSaqueMensal", source = "qtdSaqueMensal")})
    public abstract void merge(@org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.integracao.consumer.dto.AtualizarContaDTO dto, @org.jetbrains.annotations.NotNull()
    @org.mapstruct.MappingTarget()
    com.fabriciolfj.github.limites.domain.document.Limite entity);
}