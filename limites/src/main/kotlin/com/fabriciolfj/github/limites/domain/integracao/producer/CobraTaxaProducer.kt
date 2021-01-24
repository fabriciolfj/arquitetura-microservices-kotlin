package com.fabriciolfj.github.limites.domain.integracao.producer

import com.fabriciolfj.github.limites.domain.integracao.producer.dto.TaxaDTO
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class CobraTaxaProducer {

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, String>
    @Autowired
    private lateinit var objectMapper: ObjectMapper
    @Value("\${app.topic.taxa}")
    private lateinit var topic: String

    fun process(taxaDTO: TaxaDTO) {
        var json = objectMapper.writeValueAsString(taxaDTO)
        var msg = MessageBuilder.withPayload(json)
            .setHeader(KafkaHeaders.TOPIC, topic)
            .build();

        kafkaTemplate.send(msg)
    }
}