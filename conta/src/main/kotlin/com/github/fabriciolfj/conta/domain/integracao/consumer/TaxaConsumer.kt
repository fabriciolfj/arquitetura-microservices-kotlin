package com.github.fabriciolfj.conta.domain.integracao.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.fabriciolfj.conta.domain.entity.TipoTransacao
import com.github.fabriciolfj.conta.domain.integracao.consumer.dto.TaxaDTO
import com.github.fabriciolfj.conta.domain.service.OperacaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class TaxaConsumer {

    @Autowired
    private lateinit var objectMapper: ObjectMapper
    @Autowired
    private lateinit var operacaoService: OperacaoService

    @KafkaListener(topics = ["\${app.topic.taxa}"], properties = ["max.poll.interval.ms:30000"])
    fun process(msg: String) {
        var taxa = objectMapper.readValue(msg, TaxaDTO::class.java)
        operacaoService.updateValorUltimoExtrato(taxa.conta, taxa.taxa, TipoTransacao.OUTROS)
    }
}