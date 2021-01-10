package com.github.fabriciolfj.conta.api.controller

import com.github.fabriciolfj.conta.api.mapper.request.OperacaoRequest
import com.github.fabriciolfj.conta.domain.service.OperacaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/operacao")
class OperacaoController {

    @Autowired
    private lateinit var operacaoService: OperacaoService

    @PostMapping("/{conta}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun operacao(@RequestBody request: OperacaoRequest, @PathVariable("conta") conta: String) {
        operacaoService.executarOperacao(request, conta)
    }
}