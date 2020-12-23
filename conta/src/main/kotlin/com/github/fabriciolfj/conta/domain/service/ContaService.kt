package com.github.fabriciolfj.conta.domain.service

import com.github.fabriciolfj.conta.domain.repository.ContaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContaService {

    @Autowired
    lateinit var contaRepository: ContaRepository
}