package StrategyTest

import Strategy.PagamentoCartaoCredito
import Strategy.PagamentoCartaoDebito
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class PagamentoCartaoDebitoTest {
    @Test
    fun coletarDadosComValoresValidos(){
        val pagamentoDebito = PagamentoCartaoDebito()
        val pagamentoDebitoMock = Mockito.spy(pagamentoDebito)
        Mockito.doReturn("5161 3065 8173 3040").`when`(pagamentoDebitoMock).getNumeroCartao()
        Mockito.doReturn("123").`when`(pagamentoDebitoMock).getCvv()
        pagamentoDebitoMock.coletarDados(50.0)
        Assertions.assertEquals(50.0,pagamentoDebitoMock.totalPedido)
    }
}