package com.github.fabriciolfj.conta.domain.service

import com.github.fabriciolfj.conta.api.exceptions.BancoNotFoundException
import com.github.fabriciolfj.conta.api.mapper.request.ContaRequest
import com.github.fabriciolfj.conta.api.mapper.response.ContaResponse
import com.github.fabriciolfj.conta.api.mapper.ContaMapper
import com.github.fabriciolfj.conta.api.mapper.ExtratoMapper
import com.github.fabriciolfj.conta.domain.repository.BancoRepository
import com.github.fabriciolfj.conta.domain.repository.ContaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class ContaService {

    @Autowired
    private lateinit var contaRepository: ContaRepository

    @Autowired
    private lateinit var bancoRepository: BancoRepository

    @Autowired
    private lateinit var contaMapper: ContaMapper

    @Autowired
    private lateinit var extratoMapper: ExtratoMapper

    fun findAll(): List<ContaResponse> {
        return contaRepository.findAll()
            .map { contaMapper.toResponse(it) }
            .toList()
    }

    @Transactional("chainedKafkaTransactionManager", propagation = Propagation.REQUIRED)
    fun create(request: ContaRequest, banco: String) {
        var entity = bancoRepository.findByCode(banco) ?: throw BancoNotFoundException("Banco não localizado : $banco")
        contaMapper.toEntity(request)
            .apply {
                this.banco = entity
                this.extratos = listOf(extratoMapper.toEntity(request.saldo, this))
            }.apply {
                contaRepository.save(this)
            }
    }

}