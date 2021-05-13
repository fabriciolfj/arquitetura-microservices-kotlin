package com.fabriciolfj.github.limites.domain.integracao.cache;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0017J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\b8\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/fabriciolfj/github/limites/domain/integracao/cache/BatchUpdateCache;", "", "()V", "SIZE", "", "getSIZE", "()I", "atualizarCache", "Lcom/fabriciolfj/github/limites/domain/integracao/cache/AtualizarCache;", "limiteService", "Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteService;", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "getLogger", "()Lorg/slf4j/Logger;", "batch", "", "execute", "limites", "", "Lcom/fabriciolfj/github/limites/domain/document/Limite;"})
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
    
    @org.springframework.scheduling.annotation.Scheduled(cron = "0 53 21 * * ?", zone = "America/Sao_Paulo")
    public void batch() {
    }
    
    private void execute(java.util.List<com.fabriciolfj.github.limites.domain.document.Limite> limites) {
    }
    
    public BatchUpdateCache() {
        super();
    }
}