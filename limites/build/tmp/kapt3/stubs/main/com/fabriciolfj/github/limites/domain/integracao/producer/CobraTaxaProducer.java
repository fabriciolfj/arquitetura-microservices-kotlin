package com.fabriciolfj.github.limites.domain.integracao.producer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/fabriciolfj/github/limites/domain/integracao/producer/CobraTaxaProducer;", "", "()V", "kafkaTemplate", "Lorg/springframework/kafka/core/KafkaTemplate;", "", "objectMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "topic", "process", "", "taxaDTO", "Lcom/fabriciolfj/github/limites/domain/integracao/producer/dto/TaxaDTO;", "limites"})
@org.springframework.stereotype.Component()
public class CobraTaxaProducer {
    @org.springframework.beans.factory.annotation.Autowired()
    private org.springframework.kafka.core.KafkaTemplate<java.lang.String, java.lang.String> kafkaTemplate;
    @org.springframework.beans.factory.annotation.Autowired()
    private com.fasterxml.jackson.databind.ObjectMapper objectMapper;
    @org.springframework.beans.factory.annotation.Value(value = "${app.topic.taxa}")
    private java.lang.String topic;
    
    public void process(@org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.integracao.producer.dto.TaxaDTO taxaDTO) {
    }
    
    public CobraTaxaProducer() {
        super();
    }
}