package com.fabriciolfj.github.limites.api.controller

import com.fabriciolfj.github.limites.api.dto.LimiteRequest
import com.fabriciolfj.github.limites.api.dto.LimiteResponse
import com.fabriciolfj.github.limites.domain.service.limite.LimiteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/limites")
class LimiteController {

    @Autowired
    lateinit var limiteService: LimiteService

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/{conta}")
    fun findByLimite(@PathVariable("conta") conta: String ): LimiteResponse {
        return limiteService.findByLimiteResponse(conta)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvar(@RequestBody limiteRequest: LimiteRequest) {
        limiteService.create(limiteRequest)
    }
}