package com.fabriciolfj.github.limites.domain.integracao.cache;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0016\u0010\u0013\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0012J\u0016\u0010\u0017\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0012J\u001a\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001a0\u0019H\u0012J0\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001a0\u00192\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0006\u0010\u001c\u001a\u00020\u0004H\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\b8\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/fabriciolfj/github/limites/domain/integracao/cache/BatchUpdateCache;", "", "()V", "SIZE", "", "getSIZE", "()I", "atualizarCache", "Lcom/fabriciolfj/github/limites/domain/integracao/cache/AtualizarCache;", "limiteService", "Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteService;", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "getLogger", "()Lorg/slf4j/Logger;", "batchMensal", "", "bathDiario", "execute", "limites", "", "Lcom/fabriciolfj/github/limites/domain/document/Limite;", "executeReset", "getLimitePageInit", "Lkotlin/Pair;", "Lorg/springframework/data/domain/Page;", "getProximoLimitePage", "initPage"})
@org.springframework.stereotype.Component()
public class BatchUpdateCache {
    @org.springframework.beans.factory.annotation.Autowired()
    private com.fabriciolfj.github.limites.domain.service.limite.LimiteService limiteService;
    @org.springframework.beans.factory.annotation.Autowired()
    private com.fabriciolfj.github.limites.domain.integracao.cache.AtualizarCache atualizarCache;
    private final org.slf4j.Logger logger = null;
    private final int SIZE = 2;
    
    public org.slf4j.Logger getLogger() {
        return null;
    }
    
    public int getSIZE() {
        return 0;
    }
    
    public void bathDiario() {
    }
    
    public void batchMensal() {
    }
    
    private kotlin.Pair<java.lang.Integer, org.springframework.data.domain.Page<com.fabriciolfj.github.limites.domain.document.Limite>> getProximoLimitePage(org.springframework.data.domain.Page<com.fabriciolfj.github.limites.domain.document.Limite> limites, int initPage) {
        return null;
    }
    
    private kotlin.Pair<java.lang.Integer, org.springframework.data.domain.Page<com.fabriciolfj.github.limites.domain.document.Limite>> getLimitePageInit() {
        return null;
    }
    
    private void execute(java.util.List<com.fabriciolfj.github.limites.domain.document.Limite> limites) {
    }
    
    private void executeReset(java.util.List<com.fabriciolfj.github.limites.domain.document.Limite> limites) {
    }
    
    public BatchUpdateCache() {
        super();
    }
}