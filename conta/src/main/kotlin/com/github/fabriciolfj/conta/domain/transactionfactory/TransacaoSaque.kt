package com.github.fabriciolfj.conta.domain.transactionfactory

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.fabriciolfj.conta.api.exceptions.LimiteValorExcedidoExcetpion
import com.github.fabriciolfj.conta.domain.entity.TipoTransacao
import com.github.fabriciolfj.conta.domain.integracao.producer.dto.LimiteCacheDTO
import com.github.fabriciolfj.conta.domain.integracao.producer.dto.UsoContaDTO
import com.github.fabriciolfj.conta.domain.integracao.producer.LimiteProducer
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.Cache
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class TransacaoSaque : Transacao {

    private val tipo = TipoTransacao.SAQUE.descricao
    private val logger = LoggerFactory.getLogger(TransacaoSaque::class.java)
    @Autowired
    private lateinit var cache: Cache
    @Autowired
    private lateinit var objectMapper: ObjectMapper
    @Autowired
    private lateinit var limiteProducer: LimiteProducer

    override fun execute(usoContaDTO: UsoContaDTO) {
        if (this.tipo != usoContaDTO.tipo) {
            logger.info("Tipo de transacao não corresponde ao informado. Informado: ${usoContaDTO.tipo}, esperado: $tipo")
            return
        }

        val limite = convertJsonToObject(usoContaDTO)
        validarValor(limite, usoContaDTO.conta)
        limiteProducer.producer(usoContaDTO)
    }

    private fun convertJsonToObject(usoContaDTO: UsoContaDTO): LimiteCacheDTO {
        var limite = cache.get(usoContaDTO.conta)!!.get() as LimiteCacheDTO
        logger.info("Limite de saque ${limite.valor} para conta ${usoContaDTO.conta}, quantidade de saque disponivel: ${limite.saque}")
        return limite
    }

    private fun validarValor(limiteCacheDTO: LimiteCacheDTO, conta: String) {
        if (BigDecimal(limiteCacheDTO.valor!!) > BigDecimal.ZERO) {
            return
        }

        throw LimiteValorExcedidoExcetpion("Limite excedido valor de saque ${limiteCacheDTO.valor}, para conta $conta")
    }
}