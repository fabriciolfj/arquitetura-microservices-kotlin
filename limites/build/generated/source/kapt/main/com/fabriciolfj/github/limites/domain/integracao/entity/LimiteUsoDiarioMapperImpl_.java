package com.fabriciolfj.github.limites.domain.integracao.entity;

import com.fabriciolfj.github.limites.domain.document.LimiteUsoDiario;
import com.fabriciolfj.github.limites.domain.integracao.consumer.dto.UsoContaDTO;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-12T22:11:59-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
@Component
@Qualifier("delegate")
public class LimiteUsoDiarioMapperImpl_ implements LimiteUsoDiarioMapper {

    @Override
    public LimiteUsoDiario toEntity(UsoContaDTO usoContaDTO, String limite) {
        if ( usoContaDTO == null && limite == null ) {
            return null;
        }

        LimiteUsoDiario limiteUsoDiario = new LimiteUsoDiario();

        return limiteUsoDiario;
    }
}
