package com.github.fabriciolfj.conta.domain.service

import com.github.fabriciolfj.conta.api.exceptions.ExtratoNotFoundException
import com.github.fabriciolfj.conta.api.mapper.ExtratoMapper
import com.github.fabriciolfj.conta.api.mapper.request.OperacaoRequest
import com.github.fabriciolfj.conta.domain.entity.TipoTransacao
import com.github.fabriciolfj.conta.domain.repository.ExtratoRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OperacaoService {

    private var logger = LoggerFactory.getLogger(OperacaoService::class.java)

    @Autowired
    private lateinit var extratoRepository: ExtratoRepository

    @Autowired
    private lateinit var extratoMapper: ExtratoMapper

    fun executarOperacao(request: OperacaoRequest, conta: String) {
        extratoRepository.findByLastExtrato(conta)
            .map {
                var tipo = TipoTransacao.toEnum(request.tipo)
                logger.info("Ultimo extrato: $it")
                extratoMapper.toEntity(it, request.valor, tipo)
            }.map {
                extratoRepository.save(it)
            }
            .orElseThrow { throw ExtratoNotFoundException("Extrato nao encontrado para conta $conta") }
    }
}