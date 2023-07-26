package UtilsTests

import Utils.VerificaInputs
import com.github.ajalt.mordant.rendering.TextColors
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class VerificaInputsTest {

    //teste funcao fun verificaOpcao(opcao:String)
    @Test
    fun verificaOpcaoComValorEsperado(){
        assertDoesNotThrow { VerificaInputs.verificaOpcao("1")}
    }
    @Test
    fun verificaSeOpcaoEhValorNaoNumericoRetornaExcecao(){
        val exception = assertThrows(IllegalArgumentException::class.java){
            VerificaInputs.verificaOpcao("a")
        }
        assertEquals((TextColors.red("❌ Formato inválido, para escolher o item, você deve informar o número dele.")),exception.message)
    }
    @Test
    fun verificaSeOpcaoEhValorDiferenteDe1e2RetornaExcecao(){
        val exception = assertThrows(IllegalArgumentException::class.java){
            VerificaInputs.verificaOpcao("3")
        }
        assertEquals((TextColors.red("❗ Opção inválida, tente novamente")),exception.message)
    }

    //testes funcao fun verificaQuantidade(qtd:Int)
    @Test
    fun verificaQuantidadeComValorMenorZeroRetornaExcecao(){
        val exception = assertThrows(IllegalArgumentException::class.java){
            VerificaInputs.verificaQuantidade(-5)
        }
        assertEquals((TextColors.red("❌ Quantidade deve ser superior a zero")),exception.message)
    }
    @Test
    fun verificaSeQuantidadeEhMaiorQueZero(){
        assertDoesNotThrow { VerificaInputs.verificaQuantidade(1)}
    }

    //testes funcao fun verificaCvv(cvv: String)
    @Test
    fun verificaCvvComValoresNaoNumericosRetornaExcecao(){
        val exception = assertThrows(IllegalArgumentException::class.java){
            VerificaInputs.verificaCvv("abc")
        }
        assertEquals((TextColors.red("❌ Número do CVV inválido")),exception.message)
    }
    @Test
    fun verificaCvvComTamanhoDiferenteDe3RetornaExcecao(){
        val exception = assertThrows(IllegalArgumentException::class.java){
            VerificaInputs.verificaCvv("1234")
        }
        assertEquals((TextColors.red("❌ Número do CVV inválido")),exception.message)
    }
    @Test
    fun verificaCvvValido(){
        assertDoesNotThrow { VerificaInputs.verificaCvv("123")}
    }

    //testes funcao  fun verificaNumeroCartao(numeroCartao: String)
    @Test
    fun verificaNumeroCartaoValido(){
        assertDoesNotThrow { VerificaInputs.verificaNumeroCartao("5161 3065 8173 3040")}
    }
    @Test
    fun verificaNumeroCartaoInvalidoTamanhoDiferenteDe16(){
        val exception = assertThrows(IllegalArgumentException::class.java){
            VerificaInputs.verificaNumeroCartao("1234")
        }
        assertEquals((TextColors.red("❌ Número do cartão inválido")),exception.message)
    }
    @Test
    fun verificaNumeroCartaoInvalidoValoresNaoNumericos(){
        val exception = assertThrows(IllegalArgumentException::class.java){
            VerificaInputs.verificaNumeroCartao("a161 3065 8173 3040")
        }
        assertEquals((TextColors.red("❌ Número do cartão inválido")),exception.message)
    }
    @Test
    fun verificaNumeroCartaoInvalido(){
        val exception = assertThrows(IllegalArgumentException::class.java){
            VerificaInputs.verificaNumeroCartao("7161 3065 8173 3040")
        }
        assertEquals((TextColors.red("❌ Número do cartão inválido")),exception.message)
    }
    //testes funcao fun verificaOpcaoMenuSec(opcao:String)
    @Test
    fun verificaOpcaoComValorEsperadoMenuSec(){
        assertDoesNotThrow { VerificaInputs.verificaOpcaoMenuSec("3")}
    }
    @Test
    fun verificaSeOpcaoEhValorNaoNumericoRetornaExcecaoMenuSec(){
        val exception = assertThrows(IllegalArgumentException::class.java){
            VerificaInputs.verificaOpcaoMenuSec("a")
        }
        assertEquals((TextColors.red("❌ Formato inválido, para escolher o item, você deve informar o número dele.")),exception.message)
    }
    @Test
    fun verificaSeOpcaoEhValorDiferenteDe1a4RetornaExcecaoMenuSec(){
        val exception = assertThrows(IllegalArgumentException::class.java){
            VerificaInputs.verificaOpcaoMenuSec("5")
        }
        assertEquals((TextColors.red("❗ Opção inválida, tente novamente")),exception.message)
    }

    //testes funncao fun verificaPreco(preco:Double)
    @Test
    fun verificaSePrecoEhMaiorQueZero(){
        assertDoesNotThrow { VerificaInputs.verificaPreco(4.5)}
    }
    @Test
    fun verificaSePrecoEhMenorQueZero(){
        assertThrows(IllegalArgumentException::class.java){
            VerificaInputs.verificaPreco(-5.5)
        }

    }

}