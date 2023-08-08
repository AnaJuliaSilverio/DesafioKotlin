package StrategyTest

import Strategy.PagamentoValeAlimentacao
import Utils.VerificaInputs
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import java.io.ByteArrayInputStream
import java.time.LocalDate
import java.time.format.DateTimeParseException

class PagamentoValeAlimentacaoTest {

    @Test
    fun testeDataDeValidadeValida(){
        val pagamentoValeAlimentacao = PagamentoValeAlimentacao()
        val input = "10/10/2023"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertEquals(LocalDate.parse("10/10/2023",VerificaInputs.formatter),pagamentoValeAlimentacao.getDataValidade())
    }

    @Test
    fun testeDataDeValidadeNoFormatoInValido(){
        val pagamentoValeAlimentacao = PagamentoValeAlimentacao()
        val input = "10/26/2023"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(DateTimeParseException::class.java) {
            pagamentoValeAlimentacao.getDataValidade()
        }
    }
    @Test
    fun testeDataDeValidadeDataExpirada(){
        val pagamentoValeAlimentacao = PagamentoValeAlimentacao()
        val input = "10/01/2023"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            pagamentoValeAlimentacao.getDataValidade()
        }
    }
    @Test
    fun testeNumeroDeCartaoValido(){
        val pagamentoValeAlimentacao = PagamentoValeAlimentacao()
        val input = "5161 3065 8173 3040"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertEquals("5161 3065 8173 3040",pagamentoValeAlimentacao.getNumeroCartao())
    }
    @Test
    fun testeNumeroDeCartaoInValido(){
        val pagamentoValeAlimentacao = PagamentoValeAlimentacao()
        val input = "5162 3065 8173 3040"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            pagamentoValeAlimentacao.getNumeroCartao()
        }
    }
    @Test
    fun testeNumeroDeCartaoTamanhoInValido(){
        val pagamentoValeAlimentacao = PagamentoValeAlimentacao()
        val input = "5162 3065 8173"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            pagamentoValeAlimentacao.getNumeroCartao()
        }
    }
    @Test
    fun coletarDadosComValoresValidos(){
        val pagamentoVale = PagamentoValeAlimentacao()
        val pagamentoValeMock = spy(pagamentoVale)
        doReturn("5161 3065 8173 3040").`when`(pagamentoValeMock).getNumeroCartao()
        doReturn(LocalDate.parse("10/10/2023",VerificaInputs.formatter)).`when`(pagamentoValeMock).getDataValidade()
        pagamentoValeMock.coletarDados(50.0)
        Assertions.assertEquals(50.0,pagamentoValeMock.totalPedido)
    }

}