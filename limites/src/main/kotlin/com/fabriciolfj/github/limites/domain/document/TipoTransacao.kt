package com.fabriciolfj.github.limites.domain.document

import java.lang.IllegalArgumentException

enum class TipoTransacao(val descricao: String) {

    SAQUE("saque"), OUTROS("outros");

    companion object {
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