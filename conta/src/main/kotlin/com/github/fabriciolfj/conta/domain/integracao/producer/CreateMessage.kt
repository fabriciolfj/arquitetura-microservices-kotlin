package com.github.fabriciolfj.conta.domain.integracao.producer

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class CreateMessage {

    @Autowired
    private lateinit var mapper: ObjectMapper

    fun execute(messageDTO: MessageDTO, topic: String): Message<String> {
        val json = mapper.writeValueAsString(messageDTO)
        return MessageBuilder.withPayload(json)
            .setHeader(KafkaHeaders.TOPIC, topic)
            .build();
    }
}