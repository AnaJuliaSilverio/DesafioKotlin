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
        Assertions.assertEquals(produto.nome,produtoRepository.retornaProduto(1,"Lanche").nome)
    }
    @Test
    fun retornaLancheComCodigoInvalido(){
        val produtoRepository = ProdutoRepository()
        Assertions.assertThrows(IndexOutOfBoundsException::class.java) {
            produtoRepository.retornaProduto(0,"Lanche")
        }
    }
    @Test
    fun retornaBebidaSucesso(){
        val produtoRepository = ProdutoRepository()
        val produto =  Produto("Refrigente","Bebida",8.0)
        Assertions.assertEquals(produto.nome,produtoRepository.retornaProduto(1,"Bebida").nome)
    }
    @Test
    fun retornaBebidaComCodigoInvalido(){
        val produtoRepository = ProdutoRepository()
        Assertions.assertThrows(IndexOutOfBoundsException::class.java) {
            produtoRepository.retornaProduto(0,"Bebida")
        }
    }
}