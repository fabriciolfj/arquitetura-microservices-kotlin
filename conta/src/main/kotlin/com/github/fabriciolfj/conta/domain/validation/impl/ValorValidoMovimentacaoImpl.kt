package com.github.fabriciolfj.conta.domain.validation.impl

import com.github.fabriciolfj.conta.api.exceptions.ValorInvalidoExcetpion
import com.github.fabriciolfj.conta.domain.validation.MovimentacaoValidation
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class ValorValidoMovimentacaoImpl : MovimentacaoValidation {

    override fun executar(valor: BigDecimal, conta: String) {
        if (valor > BigDecimal.ZERO) {
            return
        }

        throw ValorInvalidoExcetpion("Valor do movimentado inferior ou igual a zero para a conta $conta")
    }
}