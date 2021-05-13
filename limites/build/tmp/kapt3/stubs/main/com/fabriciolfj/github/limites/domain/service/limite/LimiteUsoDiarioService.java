package com.fabriciolfj.github.limites.domain.service.limite;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\fH\u0012J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteUsoDiarioService;", "", "()V", "atualizarCache", "Lcom/fabriciolfj/github/limites/domain/integracao/cache/AtualizarCache;", "limiteUsoDiarioMapper", "Lcom/fabriciolfj/github/limites/domain/integracao/entity/LimiteUsoDiarioMapper;", "limiteUsoDiarioRepository", "Lcom/fabriciolfj/github/limites/domain/repository/LimiteUsoDiarioRepository;", "atualizarLimiteNoCache", "", "conta", "", "valor", "Ljava/math/BigDecimal;", "findUsosByLimite", "", "Lcom/fabriciolfj/github/limites/domain/document/LimiteUsoDiario;", "id", "salvar", "usoContaDTO", "Lcom/fabriciolfj/github/limites/domain/integracao/consumer/dto/UsoContaDTO;", "limite", "Lcom/fabriciolfj/github/limites/domain/document/Limite;", "limites"})
@org.springframework.stereotype.Service()
public class LimiteUsoDiarioService {
    @org.springframework.beans.factory.annotation.Autowired()
    private com.fabriciolfj.github.limites.domain.repository.LimiteUsoDiarioRepository limiteUsoDiarioRepository;
    @org.springframework.beans.factory.annotation.Autowired()
    private com.fabriciolfj.github.limites.domain.integracao.entity.LimiteUsoDiarioMapper limiteUsoDiarioMapper;
    @org.springframework.beans.factory.annotation.Autowired()
    private com.fabriciolfj.github.limites.domain.integracao.cache.AtualizarCache atualizarCache;
    
    public void salvar(@org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO usoContaDTO, @org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.document.Limite limite) {
    }
    
    private java.util.List<com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario> findUsosByLimite(java.lang.String id) {
        return null;
    }
    
    public void atualizarLimiteNoCache(@org.jetbrains.annotations.NotNull()
    java.lang.String conta, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal valor) {
    }
    
    public LimiteUsoDiarioService() {
        super();
    }
}