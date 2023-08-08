package ControllerTest

import Controller.ProcessadorPagamentoController
import Repository.Carrinho
import Strategy.PagamentoCartaoCredito
import Strategy.PagamentoCartaoDebito
import Strategy.PagamentoDinheiro
import Strategy.PagamentoValeAlimentacao
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class ProcessadorPagamentoControllerTest {
    private lateinit var carrinho: Carrinho

    private lateinit var procesadorPagamentoController: ProcessadorPagamentoController

    @BeforeEach
    fun setUp() {
        carrinho = Mockito.mock(Carrinho::class.java)
        procesadorPagamentoController = ProcessadorPagamentoController(carrinho,"Ana")
    }

    @Test
    fun criarFormaPagamentoValoresValidos(){
        val pagamentoCartaoCredito = procesadorPagamentoController.criarFormaPagamento("1")
        val pagamentoCartaoDebito = procesadorPagamentoController.criarFormaPagamento("2")
        val pagamentoValeAlimentacao = procesadorPagamentoController.criarFormaPagamento("3")
        val pagamentoDinheiro = procesadorPagamentoController.criarFormaPagamento("4")

        assertEquals(PagamentoCartaoCredito::class, pagamentoCartaoCredito!!::class)
        assertEquals(PagamentoCartaoDebito::class, pagamentoCartaoDebito!!::class)
        assertEquals(PagamentoValeAlimentacao::class, pagamentoValeAlimentacao!!::class)
        assertEquals(PagamentoDinheiro::class, pagamentoDinheiro!!::class)
    }
    @Test
    fun criarFormaPagamentoValorInvalido(){
        val pagamento = procesadorPagamentoController.criarFormaPagamento("5")
        assertNull(pagamento)
    }
}