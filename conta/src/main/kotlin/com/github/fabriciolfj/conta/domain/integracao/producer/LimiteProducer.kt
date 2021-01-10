package com.github.fabriciolfj.conta.domain.integracao.producer

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.fabriciolfj.conta.domain.integracao.dto.AtualizarContaDTO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class LimiteProducer {

    private var logger = LoggerFactory.getLogger(LimiteProducer::class.java)

    @Value("\${app.topic}")
    private lateinit var topic: String


    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, String>

    fun producer(atualizar: AtualizarContaDTO) {
        logger.info("Enviando a mensagem para o serviço limite: $atualizar")
        var mapper = ObjectMapper()
        val json = mapper.writeValueAsString(atualizar)
        val msg = MessageBuilder.withPayload(json)
            .setHeader(KafkaHeaders.TOPIC, topic)
            .build();

        kafkaTemplate.send(msg)
    }
}