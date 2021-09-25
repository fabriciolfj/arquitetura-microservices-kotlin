package com.github.fabriciolfj.conta.domain.integracao.producer

import com.github.fabriciolfj.conta.domain.integracao.producer.dto.AtualizarContaDTO
import com.github.fabriciolfj.conta.domain.integracao.producer.dto.UsoContaDTO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class LimiteProducer {

    private var logger = LoggerFactory.getLogger(LimiteProducer::class.java)

    @Value("\${app.topic}")
    private lateinit var topic: String

    @Value("\${app.topic.uso}")
    private lateinit var topicUso: String

    @Autowired
    private lateinit var createMessage: CreateMessage

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, String>

    fun producer(atualizar: AtualizarContaDTO) {
        logger.info("Enviando a mensagem para o serviço limite: $atualizar")
        val msg = createMessage.execute(atualizar, topic)

        kafkaTemplate.send(msg)
    }

    fun producer(usoContaDTO: UsoContaDTO) {
        logger.info("Enviando a mensagem para o serviço limite: $usoContaDTO")
        val msg = createMessage.execute(usoContaDTO, topicUso)

        kafkaTemplate.send(msg)
    }
}