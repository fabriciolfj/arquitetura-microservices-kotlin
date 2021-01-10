package com.fabriciolfj.github.limites.domain.integracao.cache.dto

import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.AtualizarContaDTO
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface LimiteCacheMapper {

    @Mappings(
        Mapping(source = "qtdSaqueMensal", target = "saque"),
        Mapping(source = "valorDiario", target = "valor")
    )
    fun toDto(atualizarContaDTO: AtualizarContaDTO): LimiteCacheDTO
}