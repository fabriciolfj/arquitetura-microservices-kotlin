package com.fabriciolfj.github.limites.domain.integracao.consumer

import com.fabriciolfj.github.limites.domain.integracao.cache.AtualizarCache
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.AtualizarContaDTO
import com.fabriciolfj.github.limites.domain.service.limite.LimiteService
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.util.concurrent.CompletableFuture.supplyAsync

@Component
class CriarLimiteConsumer {

    private val logger = LoggerFactory.getLogger(CriarLimiteConsumer::class.java)

    @Autowired
    private lateinit var limiteService: LimiteService

    @Autowired
    private lateinit var mapper: ObjectMapper

    @Autowired
    private lateinit var atualizarCache: AtualizarCache

    @Transactional(propagation = Propagation.REQUIRED)
    @KafkaListener(topics = ["\${app.topic}"], properties = ["max.poll.interval.ms:30000"])
    fun consumer(msg: String) {
        supplyAsync {
            var atualizarContaDTO = mapper.readValue(msg, AtualizarContaDTO::class.java)
            logger.info("Criando limite: $atualizarContaDTO")
            limiteService.create(atualizarContaDTO)
            atualizarCache.process(atualizarContaDTO.conta, atualizarContaDTO.valorDiario, atualizarContaDTO.qtdSaqueMensal)
        }.whenCompleteAsync { unit: Unit, throwable: Throwable? ->
            if (throwable != null) {
                logger.info("Falha ao executar a rotina. Detalhes: ${throwable.message}")
            }
        }
    }
}