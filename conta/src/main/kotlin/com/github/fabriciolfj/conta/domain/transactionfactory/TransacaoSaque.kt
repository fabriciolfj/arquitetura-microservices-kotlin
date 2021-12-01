package com.github.fabriciolfj.conta.domain.transactionfactory

import com.github.fabriciolfj.conta.domain.entity.TipoTransacao
import com.github.fabriciolfj.conta.domain.integracao.producer.dto.UsoContaDTO
import com.github.fabriciolfj.conta.domain.integracao.producer.LimiteProducer
import com.github.fabriciolfj.conta.domain.validation.MovimentacaoValidation
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TransacaoSaque : Transacao {

    private val tipo = TipoTransacao.SAQUE.descricao
    private val logger = LoggerFactory.getLogger(TransacaoSaque::class.java)
    @Autowired
    private lateinit var limiteProducer: LimiteProducer
    @Autowired
    private lateinit var movimentacaoValidation: List<MovimentacaoValidation>

    override fun execute(usoContaDTO: UsoContaDTO) {
        if (this.tipo != usoContaDTO.tipo) {
            logger.info("Tipo de transacao não corresponde ao informado. Informado: ${usoContaDTO.tipo}, esperado: $tipo")
            return
        }

        validar(usoContaDTO)
        produzirMensagem(usoContaDTO)
    }

    private fun produzirMensagem(usoContaDTO: UsoContaDTO) {
        limiteProducer.producer(usoContaDTO)
    }

    private fun validar(usoContaDTO: UsoContaDTO) {
        movimentacaoValidation.forEach { it.executar(usoContaDTO.valor, usoContaDTO.conta) }
    }
}