package com.fabriciolfj.github.limites.domain.integracao.cache;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0092\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/fabriciolfj/github/limites/domain/integracao/cache/AtualizarCache;", "", "()V", "cache", "Lorg/springframework/cache/Cache;", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "process", "", "conta", "", "valor", "Ljava/math/BigDecimal;", "qtdSaque", "", "updateValor", "limites"})
@org.springframework.stereotype.Component()
public class AtualizarCache {
    private org.slf4j.Logger logger;
    @org.springframework.beans.factory.annotation.Qualifier(value = "limite")
    @org.springframework.beans.factory.annotation.Autowired()
    private org.springframework.cache.Cache cache;
    
    public void process(@org.jetbrains.annotations.NotNull()
    java.lang.String conta, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal valor, int qtdSaque) {
    }
    
    public void updateValor(@org.jetbrains.annotations.NotNull()
    java.lang.String conta, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal valor) {
    }
    
    public AtualizarCache() {
        super();
    }
}