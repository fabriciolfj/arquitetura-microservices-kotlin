package com.fabriciolfj.github.limites.api.mapper

import com.fabriciolfj.github.limites.api.dto.LimiteRequest
import com.fabriciolfj.github.limites.api.dto.LimiteResponse
import com.fabriciolfj.github.limites.domain.document.Limite
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.AtualizarContaDTO
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface LimiteMapper {

    @Mappings(
            Mapping(source = "conta", target = "contaComDigito"),
            Mapping(source = "valorDiario", target = "valorDiario"),
            Mapping(source = "volumeSaque", target = "quantidadeSaqueMensal"))
    fun toEntity(request: LimiteRequest) :  Limite

    @Mappings(
        Mapping(source = "conta", target = "contaComDigito"),
        Mapping(source = "valorDiario", target = "valorDiario"),
        Mapping(source = "qtdSaqueMensal", target = "quantidadeSaqueMensal"))
    fun toEntity(dto: AtualizarContaDTO) : Limite

    @Mappings(
            Mapping(target = "saque", source = "quantidadeSaqueMensal"),
            Mapping(target = "valor", source = "valorDiario")
    )
    fun toResponse(limite: Limite): LimiteResponse
}