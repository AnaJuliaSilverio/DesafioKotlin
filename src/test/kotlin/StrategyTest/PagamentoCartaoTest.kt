package StrategyTest

import Strategy.PagamentoCartao
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class PagamentoCartaoTest {
    @Test
    fun testeNumeroDeCvvValido(){
        val pagamentoCartao = PagamentoCartao()
        val input = "123"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertEquals("123",pagamentoCartao.getCvv())
    }
    @Test
    fun testeNumeroDeCvvTamanhoInValido(){
        val pagamentoCartao = PagamentoCartao()
        val input = "51"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            pagamentoCartao.getCvv()
        }
    }
    @Test
    fun testeNumeroDeCvvValorNaoNumerico(){
        val pagamentoCartao = PagamentoCartao()
        val input = "abc"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            pagamentoCartao.getCvv()
        }
    }
    @Test
    fun testeNumeroDeCartaoValido(){
        val pagamentoCartao = PagamentoCartao()
        val input = "5161 3065 8173 3040"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertEquals("5161 3065 8173 3040",pagamentoCartao.getNumeroCartao())
    }
    @Test
    fun testeNumeroDeCartaoInValido(){
        val pagamentoCartao = PagamentoCartao()
        val input = "5162 3065 8173 3040"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            pagamentoCartao.getNumeroCartao()
        }
    }
    @Test
    fun testeNumeroDeCartaoTamanhoInValido(){
        val pagamentoCartao = PagamentoCartao()
        val input = "5162 3065 8173"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            pagamentoCartao.getNumeroCartao()
        }
    }
}