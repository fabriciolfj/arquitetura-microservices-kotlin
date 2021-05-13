package com.fabriciolfj.github.limites.domain.integracao.consumer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017R\u0012\u0010\u0003\u001a\u00020\u00048\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/fabriciolfj/github/limites/domain/integracao/consumer/AtualizarContaConsumer;", "", "()V", "atualizarCache", "Lcom/fabriciolfj/github/limites/domain/integracao/cache/AtualizarCache;", "limiteService", "Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteService;", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "mapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "consumer", "", "msg", "", "limites"})
@org.springframework.stereotype.Component()
public class AtualizarContaConsumer {
    private final org.slf4j.Logger logger = null;
    @org.springframework.beans.factory.annotation.Autowired()
    private com.fabriciolfj.github.limites.domain.service.limite.LimiteService limiteService;
    @org.springframework.beans.factory.annotation.Autowired()
    private com.fasterxml.jackson.databind.ObjectMapper mapper;
    @org.springframework.beans.factory.annotation.Autowired()
    private com.fabriciolfj.github.limites.domain.integracao.cache.AtualizarCache atualizarCache;
    
    @org.springframework.kafka.annotation.KafkaListener(topics = {"${app.topic}"}, properties = {"max.poll.interval.ms:30000"})
    @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED)
    public void consumer(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public AtualizarContaConsumer() {
        super();
    }
}