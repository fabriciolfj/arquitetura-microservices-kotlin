package com.github.fabriciolfj.conta.domain.service

import com.github.fabriciolfj.conta.api.exceptions.BancoNotFoundException
import com.github.fabriciolfj.conta.domain.repository.BancoRepository
import org.springframework.stereotype.Service

@Service
class BancoService {

    private lateinit var bancoRepository: BancoRepository

    fun getBanco(code: String) =
         bancoRepository.findByCode(code)
             ?: throw BancoNotFoundException("Banco não localizado : $code")
}