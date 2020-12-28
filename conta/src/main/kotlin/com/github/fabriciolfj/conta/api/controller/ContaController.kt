package com.github.fabriciolfj.conta.api.controller

import com.github.fabriciolfj.conta.api.mapper.request.ContaRequest
import com.github.fabriciolfj.conta.api.mapper.response.ContaResponse
import com.github.fabriciolfj.conta.domain.service.ContaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contas")
class ContaController {

    @Autowired
    lateinit var contaService: ContaService

    @PostMapping("/{banco}")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: ContaRequest, @PathVariable("banco") banco: String) {
        contaService.create(request, banco)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun findAll() : List<ContaResponse> {
        return contaService.findAll();
    }
}