package com.fabriciolfj.github.limites.domain.integracao.consumer

import com.fabriciolfj.github.limites.domain.integracao.dto.AtualizarContaDTO
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class AtualizarContaConsumer {

    private val logger = LoggerFactory.getLogger(AtualizarContaConsumer::class.java)

    @KafkaListener(topics = arrayOf("\${app.topic}'"), properties = arrayOf("max.poll.interval.ms:4000"))
    fun consumer(atualizarContaDTO: AtualizarContaDTO) {
        logger.info(atualizarContaDTO.toString())
    }
}