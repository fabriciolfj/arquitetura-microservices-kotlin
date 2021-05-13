package com.fabriciolfj.github.limites.api.mapper;

import com.fabriciolfj.github.limites.api.dto.LimiteRequest;
import com.fabriciolfj.github.limites.api.dto.LimiteResponse;
import com.fabriciolfj.github.limites.domain.document.Limite;
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.AtualizarContaDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-12T22:42:16-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
@Component
public class LimiteMapperImpl implements LimiteMapper {

    @Override
    public Limite toEntity(LimiteRequest request) {
        if ( request == null ) {
            return null;
        }

        Limite limite = new Limite();

        limite.setQuantidadeSaqueMensal( request.getVolumeSaque() );
        limite.setValorDiario( request.getValorDiario() );
        limite.setContaComDigito( request.getConta() );

        return limite;
    }

    @Override
    public Limite toEntity(AtualizarContaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Limite limite = new Limite();

        limite.setQuantidadeSaqueMensal( dto.getQtdSaqueMensal() );
        limite.setValorDiario( dto.getValorDiario() );
        limite.setContaComDigito( dto.getConta() );

        return limite;
    }

    @Override
    public LimiteResponse toResponse(Limite limite) {
        if ( limite == null ) {
            return null;
        }

        LimiteResponse limiteResponse = new LimiteResponse();

        limiteResponse.setValor( limite.getValorDiario() );
        limiteResponse.setSaque( limite.getQuantidadeSaqueMensal() );

        return limiteResponse;
    }

    @Override
    public void merge(AtualizarContaDTO dto, Limite entity) {
        if ( dto == null ) {
            return;
        }

        entity.setQuantidadeSaqueMensal( dto.getQtdSaqueMensal() );
        entity.setValorDiario( dto.getValorDiario() );
        entity.setContaComDigito( dto.getConta() );
    }
}
