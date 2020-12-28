package com.github.fabriciolfj.conta.domain.service

import com.github.fabriciolfj.conta.api.exceptions.BancoNotFoundException
import com.github.fabriciolfj.conta.api.mapper.request.ContaRequest
import com.github.fabriciolfj.conta.api.mapper.request.ContaRequestMapper
import com.github.fabriciolfj.conta.api.mapper.response.ContaResponse
import com.github.fabriciolfj.conta.api.mapper.response.ContaResponseMapper
import com.github.fabriciolfj.conta.domain.repository.BancoRepository
import com.github.fabriciolfj.conta.domain.repository.ContaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContaService {

    @Autowired
    private lateinit var contaRepository: ContaRepository

    @Autowired
    private lateinit var bancoRepository: BancoRepository

    @Autowired
    private lateinit var contaResponseMapper: ContaResponseMapper

    @Autowired
    private lateinit var contaRequestMapper: ContaRequestMapper

    fun findAll(): List<ContaResponse> {
        return contaRepository.findAll()
            .map { contaResponseMapper.toResponse(it) }
            .toList()
    }

    fun create(request: ContaRequest, banco: String) {
        var entity = bancoRepository.findByCode(banco) ?: throw BancoNotFoundException("Banco não localizado : $banco")
        contaRequestMapper.toEntity(request)
            .apply {
                this.banco = entity
            }.apply {
                contaRepository.save(this)
            }
    }

}