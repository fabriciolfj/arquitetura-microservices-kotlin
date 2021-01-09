package com.github.fabriciolfj.conta.domain.integracao.producer

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.fabriciolfj.conta.domain.integracao.dto.AtualizarContaDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class LimiteProducer {

    @Value("\$(app.topic)")
    private lateinit var topic: String

    @Autowired
    private lateinit var mapper: ObjectMapper

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, String>

    fun producer(atualizar: AtualizarContaDTO) {
        val json = mapper.writeValueAsString(atualizar)
        val msg = MessageBuilder.withPayload(json)
            .setHeader(KafkaHeaders.TOPIC, topic)
            .build();

        kafkaTemplate.send(msg)
    }
}