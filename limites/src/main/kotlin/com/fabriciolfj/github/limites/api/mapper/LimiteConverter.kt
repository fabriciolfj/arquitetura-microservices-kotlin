package com.fabriciolfj.github.limites.api.mapper

import com.fabriciolfj.github.limites.api.dto.LimiteRequest
import com.fabriciolfj.github.limites.api.dto.LimiteResponse
import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.AtualizarContaDTO

class LimiteConverter {

    companion object {

        fun toResponse(limite: Limite): LimiteResponse {
            return LimiteResponse(limite.quantidadeSaqueMensal, limite.valorDiario)
        }

        fun toEntity(dto: AtualizarContaDTO): Limite {
            return Limite(null, dto.conta, dto.valorDiario, dto.qtdSaqueMensal)
        }

        fun toEntity(request: LimiteRequest): Limite {
            return Limite(null, request.conta, request.valorDiario, request.volumeSaque)
        }
    }
}