package com.github.fabriciolfj.conta.domain.integracao.producer

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.fabriciolfj.conta.domain.integracao.producer.dto.AtualizarContaDTO
import com.github.fabriciolfj.conta.domain.integracao.producer.dto.UsoContaDTO
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

    @Value("\${app.topic.uso}")
    private lateinit var topicUso: String

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

    fun producer(usoContaDto: UsoContaDTO) {
        logger.info("Enviando a mensagem para o serviço limite: $usoContaDto")
        var mapper = ObjectMapper()
        val json = mapper.writeValueAsString(usoContaDto)
        val msg = MessageBuilder.withPayload(json)
            .setHeader(KafkaHeaders.TOPIC, topicUso)
            .build();

        kafkaTemplate.send(msg)
    }
}