package com.fabriciolfj.github.limites.domain.service.limite;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteService;", "", "()V", "limiteMapper", "Lcom/fabriciolfj/github/limites/api/mapper/LimiteMapper;", "limiteRepository", "Lcom/fabriciolfj/github/limites/domain/repository/LimiteRepository;", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "getLogger", "()Lorg/slf4j/Logger;", "create", "Lcom/fabriciolfj/github/limites/domain/document/Limite;", "limite", "Lcom/fabriciolfj/github/limites/api/dto/LimiteRequest;", "", "atualizarContaDTO", "Lcom/fabriciolfj/github/limites/domain/integracao/consumer/dto/AtualizarContaDTO;", "findAll", "Lorg/springframework/data/domain/Page;", "page", "Lorg/springframework/data/domain/Pageable;", "findByLimite", "Ljava/util/Optional;", "conta", "", "findByLimiteResponse", "Lcom/fabriciolfj/github/limites/api/dto/LimiteResponse;", "limites"})
@org.springframework.stereotype.Service()
public class LimiteService {
    @org.springframework.beans.factory.annotation.Autowired()
    private com.fabriciolfj.github.limites.domain.repository.LimiteRepository limiteRepository;
    @org.springframework.beans.factory.annotation.Autowired()
    private com.fabriciolfj.github.limites.api.mapper.LimiteMapper limiteMapper;
    private final org.slf4j.Logger logger = null;
    
    public org.slf4j.Logger getLogger() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.springframework.data.domain.Page<com.fabriciolfj.github.limites.domain.document.Limite> findAll(@org.jetbrains.annotations.NotNull()
    org.springframework.data.domain.Pageable page) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.fabriciolfj.github.limites.domain.document.Limite create(@org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.api.dto.LimiteRequest limite) {
        return null;
    }
    
    public void create(@org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.integracao.consumer.dto.AtualizarContaDTO atualizarContaDTO) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.fabriciolfj.github.limites.api.dto.LimiteResponse findByLimiteResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String conta) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.Optional<com.fabriciolfj.github.limites.domain.document.Limite> findByLimite(@org.jetbrains.annotations.NotNull()
    java.lang.String conta) {
        return null;
    }
    
    public LimiteService() {
        super();
    }
}