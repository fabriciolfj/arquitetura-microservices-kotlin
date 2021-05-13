package com.fabriciolfj.github.limites.domain.service.taxa;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/fabriciolfj/github/limites/domain/service/taxa/RegraTaxaService;", "", "execute", "", "usos", "", "Lcom/fabriciolfj/github/limites/domain/document/LimiteUsoDiario;", "valor", "Ljava/math/BigDecimal;", "limite", "Lcom/fabriciolfj/github/limites/domain/document/Limite;", "limites"})
public abstract interface RegraTaxaService {
    
    public abstract boolean execute(@org.jetbrains.annotations.NotNull()
    java.util.List<com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario> usos, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal valor, @org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.document.Limite limite);
}