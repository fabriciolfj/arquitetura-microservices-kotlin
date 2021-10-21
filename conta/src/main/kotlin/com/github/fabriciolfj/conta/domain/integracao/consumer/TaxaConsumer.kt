package com.github.fabriciolfj.conta.domain.integracao.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.fabriciolfj.conta.domain.entity.TipoTransacao
import com.github.fabriciolfj.conta.domain.integracao.consumer.dto.TaxaDTO
import com.github.fabriciolfj.conta.domain.service.OperacaoService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component

@Component
class TaxaConsumer {

    @Autowired
    private lateinit var objectMapper: ObjectMapper
    @Autowired
    private lateinit var operacaoService: OperacaoService

    private var log = LoggerFactory.getLogger(TaxaConsumer::class.java)

    @KafkaListener(topics = ["\${app.topic.taxa}"], properties = ["max.poll.interval.ms:30000"],)
    fun process(msg: String, ack: Acknowledgment) {
        try {
            var taxa = objectMapper.readValue(msg, TaxaDTO::class.java)
            operacaoService.updateValorUltimoExtrato(taxa.conta, taxa.taxa, TipoTransacao.OUTROS)

            ack.acknowledge()
        } catch (e: Exception) {
            log.error("Fail consumer topic taxa. Details: {}", e.message)
        }

    }
}