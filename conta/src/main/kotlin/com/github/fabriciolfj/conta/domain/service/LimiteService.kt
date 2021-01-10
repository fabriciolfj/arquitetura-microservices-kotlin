package com.github.fabriciolfj.conta.domain.service

import com.github.fabriciolfj.conta.api.exceptions.ContaNotFoundException
import com.github.fabriciolfj.conta.api.mapper.AtualizarContaMapper
import com.github.fabriciolfj.conta.api.mapper.request.LimiteRequest
import com.github.fabriciolfj.conta.domain.integracao.producer.LimiteProducer
import com.github.fabriciolfj.conta.domain.repository.ContaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LimiteService {

    @Autowired
    private lateinit var limiteProducer: LimiteProducer

    @Autowired
    private lateinit var atualizarContaMapper: AtualizarContaMapper

    @Autowired
    private lateinit var contaRepository: ContaRepository

    @Transactional("chainedKafkaTransactionManager")
    fun create(conta: String, limiteRequest: LimiteRequest) {
        if (!contaRepository.findByNumero(conta).isPresent) {
            throw ContaNotFoundException("Conta não encontrada: $conta")
        }

        val atualizar = atualizarContaMapper.toDto(limiteRequest, conta)
        limiteProducer.producer(atualizar)
    }
}