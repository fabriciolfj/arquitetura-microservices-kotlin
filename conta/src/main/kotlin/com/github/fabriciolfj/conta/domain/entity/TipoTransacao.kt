package com.github.fabriciolfj.conta.domain.entity

import java.lang.IllegalArgumentException

enum class TipoTransacao(val descricao: String) {

    SAQUE("saque"), OUTROS("outros"), ABERTURA("abertura"), CHEQUEESPECIAL("chequeespecial");

    companion object {
        fun toEnum(value: String): TipoTransacao {
            for(tipo in values()) {
                if (tipo.descricao.equals(value)) {
                    return tipo
                }
            }

            throw IllegalArgumentException("Tipo de transacao não localizado")
        }

        fun toDescricao(value: String): String {
            for(tipo in values()) {
                if (tipo.descricao.equals(value)) {
                    return tipo.descricao
                }
            }

            throw IllegalArgumentException("Tipo de transacao não localizado")
        }
    }
}