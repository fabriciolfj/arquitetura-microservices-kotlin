package com.fabriciolfj.github.limites.domain.integracao.consumer

import com.fabriciolfj.github.limites.api.exceptions.LimiteValorExcedidoException
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO
import com.fabriciolfj.github.limites.domain.service.limite.LimiteTaxaAgregatorService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture.supplyAsync

@Component
class UsoLimiteConsumer {

    @Autowired
    private lateinit var objectMapper: ObjectMapper
    @Autowired
    private lateinit var limiteTaxaAgregatorService: LimiteTaxaAgregatorService

    @KafkaListener(topics = ["\${app.topic.uso}"], properties = ["max.poll.interval.ms:30000"])
    fun processo(msg: String) {
        supplyAsync {
            var usoContaDTO = objectMapper.readValue(msg, UsoContaDTO::class.java)
            limiteTaxaAgregatorService.execute(usoContaDTO)
        }.whenComplete{ unit: Unit, throwable: Throwable ->
            if (throwable != null) {
                throw LimiteValorExcedidoException("Falha ao atualizar o limite de uso. Causa: ${throwable.message}")
            }
        }
    }
}