package com.fabriciolfj.github.limites.domain.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/fabriciolfj/github/limites/domain/repository/LimiteRepository;", "Lorg/springframework/data/mongodb/repository/MongoRepository;", "Lcom/fabriciolfj/github/limites/domain/document/Limite;", "", "findByContaComDigito", "Ljava/util/Optional;", "conta", "limites"})
public abstract interface LimiteRepository extends org.springframework.data.mongodb.repository.MongoRepository<com.fabriciolfj.github.limites.domain.document.Limite, java.lang.String> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.Optional<com.fabriciolfj.github.limites.domain.document.Limite> findByContaComDigito(@org.jetbrains.annotations.NotNull()
    java.lang.String conta);
}