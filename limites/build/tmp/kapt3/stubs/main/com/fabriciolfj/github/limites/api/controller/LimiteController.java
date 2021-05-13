package com.fabriciolfj.github.limites.api.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0017J\u0012\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0017R\u001e\u0010\u0003\u001a\u00020\u00048\u0016@\u0016X\u0097.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/fabriciolfj/github/limites/api/controller/LimiteController;", "", "()V", "limiteService", "Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteService;", "getLimiteService", "()Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteService;", "setLimiteService", "(Lcom/fabriciolfj/github/limites/domain/service/limite/LimiteService;)V", "findByLimite", "Lcom/fabriciolfj/github/limites/api/dto/LimiteResponse;", "conta", "", "salvar", "", "limiteRequest", "Lcom/fabriciolfj/github/limites/api/dto/LimiteRequest;", "limites"})
@org.springframework.web.bind.annotation.RequestMapping(value = {"/limites"})
@org.springframework.web.bind.annotation.RestController()
public class LimiteController {
    @org.springframework.beans.factory.annotation.Autowired()
    public com.fabriciolfj.github.limites.domain.service.limite.LimiteService limiteService;
    
    @org.jetbrains.annotations.NotNull()
    public com.fabriciolfj.github.limites.domain.service.limite.LimiteService getLimiteService() {
        return null;
    }
    
    public void setLimiteService(@org.jetbrains.annotations.NotNull()
    com.fabriciolfj.github.limites.domain.service.limite.LimiteService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.GetMapping(value = {"/{conta}"})
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
    public com.fabriciolfj.github.limites.api.dto.LimiteResponse findByLimite(@org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.PathVariable(value = "conta")
    java.lang.String conta) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
    @org.springframework.web.bind.annotation.PostMapping()
    public void salvar(@org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.RequestBody()
    com.fabriciolfj.github.limites.api.dto.LimiteRequest limiteRequest) {
    }
    
    public LimiteController() {
        super();
    }
}