package com.github.fabriciolfj.conta.api.controller

import com.github.fabriciolfj.conta.api.mapper.request.LimiteRequest
import com.github.fabriciolfj.conta.domain.service.LimiteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/limites")
class LimiteController {

    @Autowired
    lateinit var limiteService: LimiteService

    @PostMapping("/{conta}")
    @ResponseStatus(HttpStatus.CREATED)
    fun setLimite(@RequestBody limiteRequest: LimiteRequest, @PathVariable("conta") conta: String) {
        limiteService.create(conta, limiteRequest)
    }
}