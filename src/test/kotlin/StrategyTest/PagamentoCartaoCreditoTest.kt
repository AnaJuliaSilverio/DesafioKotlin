package StrategyTest

import Strategy.PagamentoCartaoCredito
import Strategy.PagamentoValeAlimentacao
import Utils.VerificaInputs
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.time.LocalDate

class PagamentoCartaoCreditoTest {
    @Test
    fun coletarDadosComValoresValidos(){
        val pagamentoCredito = PagamentoCartaoCredito()
        val pagamentoCreditoMock = Mockito.spy(pagamentoCredito)
        Mockito.doReturn("5161 3065 8173 3040").`when`(pagamentoCreditoMock).getNumeroCartao()
        Mockito.doReturn("123").`when`(pagamentoCreditoMock).getCvv()
        pagamentoCreditoMock.coletarDados(50.0)
        Assertions.assertEquals(50.0,pagamentoCreditoMock.totalPedido)
    }

}