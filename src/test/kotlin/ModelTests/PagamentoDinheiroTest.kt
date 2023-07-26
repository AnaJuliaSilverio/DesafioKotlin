package ModelTests

import Model.PagamentoDinheiro
import Utils.VerificaInputs
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.junit.jupiter.MockitoSettings
import java.io.ByteArrayInputStream

@MockitoSettings
class PagamentoDinheiroTest {
    lateinit var pagamentoDinheiro:PagamentoDinheiro
    @BeforeEach
    fun setUp(){
        // Configura a entrada padrão para o System.in com um valor simulado
        val input = "20.0"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        pagamentoDinheiro = PagamentoDinheiro()
    }
    @Test
    fun verificaTrocoQuandoValorRecebidoEhMaior(){
        pagamentoDinheiro.efetuarPagamento(6.0)
        Assertions.assertEquals(14.0,pagamentoDinheiro.troco)
    }
    @Test
    fun verificaTrocoQuandoValorRecebidoIgual(){
        pagamentoDinheiro.efetuarPagamento(20.0)
        Assertions.assertEquals(0.0,pagamentoDinheiro.troco)
    }

}