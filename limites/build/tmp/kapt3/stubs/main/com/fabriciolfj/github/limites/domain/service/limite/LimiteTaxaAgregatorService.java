package com.fabriciolfj.github.limites.domain.service.limite;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0012J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0012J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0012R\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X\u0097.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0016@\u0016X\u0097.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0016@\u0016X\u0097.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteTaxaAgregatorService;", "", "()V", "cobrarTaxaService", "Lcom/fabriciolfj/github/limites/domain/service/taxa/CobrarTaxaService;", "getCobrarTaxaService", "()Lcom/fabriciolfj/github/limites/domain/service/taxa/CobrarTaxaService;", "setCobrarTaxaService", "(Lcom/fabriciolfj/github/limites/domain/service/taxa/CobrarTaxaService;)V", "limiteService", "Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteService;", "getLimiteService", "()Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteService;", "setLimiteService", "(Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteService;)V", "limiteUsoDiarioService", "Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteUsoDiarioService;", "getLimiteUsoDiarioService", "()Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteUsoDiarioService;", "setLimiteUsoDiarioService", "(Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteUsoDiarioService;)V", "atualizarUsoValorCache", "", "usoContaDTO", "Lcom/fabriciolfj/github/limites/domain/integracao/consumer/dto/UsoContaDTO;", "createLimiteUso", "it", "Lcom/fabriciolfj/github/limites/domain/document/Limite;", "execute", "executeCobrancataxa", "limites"})
@org.springframework.stereotype.Service()
public class LimiteTaxaAgregatorService {
    @org.springframework.beans.factory.annotation.Autowired()
    public com.fabriciolfj.github.limites.domain.service.limite.LimiteService limiteService;
    @org.springframework.beans.factory.annotation.Autowired()
    public com.fabriciolfj.github.limites.domain.service.limite.LimiteUsoDiarioService limiteUsoDiarioService;
    @org.springframework.beans.factory.annotation.Autowired()
    public com.fabriciolfj.github.limites.domain.service.taxa.CobrarTaxaService cobrarTaxaService;
    
    @org.jetbrains.annotations.NotNull()
    public com.fabriciolfj.github.limites.domain.service.limite.LimiteService getLimiteService() {
        return null;
    }
    
    public void setLimiteService(@org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.service.limite.LimiteService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.fabriciolfj.github.limites.domain.service.limite.LimiteUsoDiarioService getLimiteUsoDiarioService() {
        return null;
    }
    
    public void setLimiteUsoDiarioService(@org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.service.limite.LimiteUsoDiarioService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.fabriciolfj.github.limites.domain.service.taxa.CobrarTaxaService getCobrarTaxaService() {
        return null;
    }
    
    public void setCobrarTaxaService(@org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.service.taxa.CobrarTaxaService p0) {
    }
    
    public void execute(@org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO usoContaDTO) {
    }
    
    private void executeCobrancataxa(com.fabriciolfj.github.limites.domain.document.Limite it, com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO usoContaDTO) {
    }
    
    private void createLimiteUso(com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO usoContaDTO, com.fabriciolfj.github.limites.domain.document.Limite it) {
    }
    
    private void atualizarUsoValorCache(com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO usoContaDTO) {
    }
    
    public LimiteTaxaAgregatorService() {
        super();
    }
}