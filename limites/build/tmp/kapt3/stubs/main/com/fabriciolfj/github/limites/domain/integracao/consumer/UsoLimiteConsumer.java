package com.fabriciolfj.github.limites.domain.integracao.consumer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017R\u0012\u0010\u0003\u001a\u00020\u00048\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/fabriciolfj/github/limites/domain/integracao/consumer/UsoLimiteConsumer;", "", "()V", "limiteTaxaAgregatorService", "Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteTaxaAgregatorService;", "objectMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "processo", "", "msg", "", "limites"})
@org.springframework.stereotype.Component()
public class UsoLimiteConsumer {
    @org.springframework.beans.factory.annotation.Autowired()
    private com.fasterxml.jackson.databind.ObjectMapper objectMapper;
    @org.springframework.beans.factory.annotation.Autowired()
    private com.fabriciolfj.github.limites.domain.service.limite.LimiteTaxaAgregatorService limiteTaxaAgregatorService;
    
    @org.springframework.kafka.annotation.KafkaListener(topics = {"${app.topic.uso}"}, properties = {"max.poll.interval.ms:30000"})
    public void processo(@org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public UsoLimiteConsumer() {
        super();
    }
}