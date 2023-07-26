package RepositoryTest

import Model.Produto
import Repository.ProdutoRepository
import Utils.VerificaInputs
import com.github.ajalt.mordant.rendering.TextColors
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProdutoRepositoryTest {

    @Test
    fun retornaLancheSucesso(){
        val produtoRepository = ProdutoRepository()
        val produto =  Produto("X-burger","Lanche",10.0)
        Assertions.assertEquals(produto.nome,produtoRepository.retornaLanche(1).nome)
    }
    @Test
    fun retornaLancheComCodigoInvalido(){
        val produtoRepository = ProdutoRepository()
        Assertions.assertThrows(IndexOutOfBoundsException::class.java) {
            produtoRepository.retornaLanche(0)
        }
    }
    @Test
    fun retornaBebidaSucesso(){
        val produtoRepository = ProdutoRepository()
        val produto =  Produto("Refrigente","Bebida",8.0)
        Assertions.assertEquals(produto.nome,produtoRepository.retornaBebidas(1).nome)
    }
    @Test
    fun retornaBebidaComCodigoInvalido(){
        val produtoRepository = ProdutoRepository()
        Assertions.assertThrows(IndexOutOfBoundsException::class.java) {
            produtoRepository.retornaBebidas(0)
        }
    }
}