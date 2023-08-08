package ControllerTest

import Controller.CarrinhoController
import Model.Produto
import Repository.Carrinho
import Repository.ProdutoRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoSettings
import kotlin.IndexOutOfBoundsException


@MockitoSettings
class CarrinhoControllerTest {
    private lateinit var carrinho: Carrinho
    private lateinit var produtoRepository: ProdutoRepository
    private lateinit var carrinhoController: CarrinhoController

    @BeforeEach
    fun setUp() {
        carrinho = mock(Carrinho::class.java)
        produtoRepository = mock(ProdutoRepository::class.java)
        carrinhoController = CarrinhoController(carrinho, produtoRepository)

    }

    @Test
    fun atualizarProdutoCarrinhoCodValido(){
        val produto = Produto("X-Burger", "Lanche", 10.0)
        `when`(carrinho.produtoExiste(anyInt())).thenReturn(produto)
        carrinhoController.atualizarCarrinho(produto.codigo,3)
        verify(carrinho).atualizarQuantidade(produto,3)
    }
    @Test
    fun atualizarProdutoCarrinhoCodInvalido(){
        val produto = Produto("X-Burger", "Lanche", 10.0)
        `when`(carrinho.produtoExiste(anyInt())).thenReturn(null)
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            carrinhoController.atualizarCarrinho(produto.codigo,3)
        }
        verify(carrinho, never()).atualizarQuantidade(produto,3)
    }
    @Test
    fun verificaSeProdutoExisteCodValido(){
        val produto = Produto("X-Burger", "Lanche", 10.0)
        `when`(carrinho.produtoExiste(anyInt())).thenReturn(produto)
        Assertions.assertEquals(produto,carrinhoController.verificaCodigoProduto(produto.codigo))
    }
    @Test
    fun verificaSeProdutoExisteCodInvalido(){
        val produto = Produto("X-Burger", "Lanche", 10.0)
        `when`(carrinho.produtoExiste(anyInt())).thenReturn(null)
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            carrinhoController.verificaCodigoProduto(produto.codigo)
        }
    }
    @Test
    fun adicionarProdutoOpcaoValida(){
        val produto = Produto("X-Burger", "Lanche", 10.0)
        `when`(produtoRepository.retornaProduto(anyInt(), anyString())).thenReturn(produto)
        carrinhoController.adicionarProduto(1,2,"Lanche")
        verify(carrinho).adicionarProduto(produto,2)
    }
    @Test
    fun adicionarProdutoOpcaoInvalida(){
        val produto = Produto("X-Burger", "Lanche", 10.0)
        `when`(produtoRepository.retornaProduto(anyInt(), anyString())).thenThrow(IndexOutOfBoundsException("Codigo invalido"))
        Assertions.assertThrows(IndexOutOfBoundsException::class.java) {
            carrinhoController.adicionarProduto(7,2,"Lanche")
        }
        verify(carrinho, never()).adicionarProduto(produto, 2)
    }

    @Test
    fun removerProdutoCarrinhoCodigoValido(){
        val produto = Produto("X-Burger", "Lanche", 10.0)
        `when`(carrinho.produtoExiste(produto.codigo)).thenReturn(produto)
        carrinhoController.removerProdutoCarrinho(produto.codigo)
        verify(carrinho).retirarProdutoCarrinho(produto)
    }
    @Test
    fun removerProdutoCarrinhoCodigoInValido(){
        val produto = Produto("X-Burger", "Lanche", 10.0)
        `when`(carrinho.produtoExiste(produto.codigo)).thenReturn(null)
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            carrinhoController.removerProdutoCarrinho(produto.codigo)
        }

        verify(carrinho, never()).retirarProdutoCarrinho(produto)
    }

}
