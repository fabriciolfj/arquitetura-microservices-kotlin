package com.fabriciolfj.github.limites.domain.service.taxa;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006H\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/fabriciolfj/github/limites/domain/service/taxa/CobrarTaxaService;", "", "()V", "cobraTaxaProducer", "Lcom/fabriciolfj/github/limites/domain/integracao/producer/CobraTaxaProducer;", "regras", "", "Lcom/fabriciolfj/github/limites/domain/service/taxa/RegraTaxaService;", "execute", "", "limite", "Lcom/fabriciolfj/github/limites/domain/document/Limite;", "usoContaDTO", "Lcom/fabriciolfj/github/limites/domain/integracao/consumer/dto/UsoContaDTO;", "usos", "Lcom/fabriciolfj/github/limites/domain/document/LimiteUsoDiario;", "limites"})
@org.springframework.stereotype.Service()
public class CobrarTaxaService {
    @org.springframework.beans.factory.annotation.Autowired()
    private java.util.List<? extends com.fabriciolfj.github.limites.domain.service.taxa.RegraTaxaService> regras;
    @org.springframework.beans.factory.annotation.Autowired()
    private com.fabriciolfj.github.limites.domain.integracao.producer.CobraTaxaProducer cobraTaxaProducer;
    
    public void execute(@org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.document.Limite limite, @org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO usoContaDTO, @org.jetbrains.annotations.NotNull()
    java.util.List<com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario> usos) {
    }
    
    public CobrarTaxaService() {
        super();
    }
}