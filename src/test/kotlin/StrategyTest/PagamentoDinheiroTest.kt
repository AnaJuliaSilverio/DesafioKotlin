package StrategyTest

import Strategy.PagamentoDinheiro
import Utils.VerificaInputs
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import java.io.ByteArrayInputStream
import java.lang.RuntimeException

class PagamentoDinheiroTest {

    @Test
    fun coletarDadosComValorValidoMaiorQueTotal(){
        val pagamentoDinheiro = PagamentoDinheiro()
        val input = "50.0"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        pagamentoDinheiro.coletarDados(40.0)
        assertEquals(10.0, pagamentoDinheiro.dinheiro.troco)
        assertEquals(50.0, pagamentoDinheiro.dinheiro.valorRecebido)
    }
    @Test
    fun coletarDadosComValorValidoIgualAoTotal(){
        val pagamentoDinheiro = PagamentoDinheiro()
        val input = "50.0"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        pagamentoDinheiro.coletarDados(50.0)
        assertEquals(0.0, pagamentoDinheiro.dinheiro.troco)
        assertEquals(50.0, pagamentoDinheiro.dinheiro.valorRecebido)
    }
    @Test
    fun coletarDadosComValorInValidoMenorAoTotal(){
        val pagamentoDinheiro = PagamentoDinheiro()
        val input = "30.0"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(RuntimeException::class.java) {
            pagamentoDinheiro.coletarDados(50.0)
        }
    }
    @Test
    fun coletarDadosComValorInValidoNaoNumerico(){
        val pagamentoDinheiro = PagamentoDinheiro()
        val input = "a"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(RuntimeException::class.java) {
            pagamentoDinheiro.coletarDados(50.0)
        }
    }


}