package com.github.fabriciolfj.conta.api.controller

import com.github.fabriciolfj.conta.api.mapper.request.ContaRequest
import com.github.fabriciolfj.conta.api.mapper.response.ContaResponse
import com.github.fabriciolfj.conta.domain.service.ContaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/contas")
class ContaController {

    @Autowired
    lateinit var contaService: ContaService

    @PostMapping("/{banco}")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody request: ContaRequest, @PathVariable("banco") banco: String) {
        contaService.processCreation(request, banco)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun findAll() : List<ContaResponse> {
        return contaService.findAllContaResponse();
    }
}