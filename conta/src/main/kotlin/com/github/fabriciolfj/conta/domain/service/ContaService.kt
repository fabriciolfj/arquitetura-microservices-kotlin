package com.github.fabriciolfj.conta.domain.service

import com.github.fabriciolfj.conta.api.exceptions.ContaExistsException
import com.github.fabriciolfj.conta.api.exceptions.ContaNotFoundException
import com.github.fabriciolfj.conta.api.mapper.request.ContaRequest
import com.github.fabriciolfj.conta.api.mapper.response.ContaResponse
import com.github.fabriciolfj.conta.api.mapper.ContaMapper
import com.github.fabriciolfj.conta.api.mapper.ExtratoMapper
import com.github.fabriciolfj.conta.domain.entity.Conta
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
    private lateinit var contaMapper: ContaMapper

    @Autowired
    private lateinit var extratoMapper: ExtratoMapper

    @Autowired
    private lateinit var bancoService: BancoService

    fun findAllContaResponse(): List<ContaResponse> {
        return this.findAll()
            .map { contaMapper.toResponse(it) }
            .toList()
    }

    fun findAll(): List<Conta> {
        return contaRepository.findAll();
    }

    fun findByConta(conta: String) : Conta {
        return contaRepository.findByNumero(conta)
            .orElseThrow { throw ContaNotFoundException("Conta não encontrada: $conta")}
    }

    @Transactional("chainedKafkaTransactionManager")
    fun processCreation(request: ContaRequest, banco: String) {
        if (contaRepository.findByNumero(request.numero).isPresent) {
            throw ContaExistsException("Ja existe um cadastro para conta ${request.numero}")
        }

        create(request, banco)
    }

    private fun create(request: ContaRequest, banco: String) {
        contaMapper.toEntity(request)
            .apply {
                var entity = bancoService.getBanco(banco)
                this.banco = entity
                this.extratos = listOf(extratoMapper.toEntity(request.saldo, this))
            }.apply {
                contaRepository.save(this)
            }
    }

}