package RepositoryTest

import Model.Produto
import Repository.Carrinho
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
class CarrinhoTest {

    val carrinho = Carrinho()
    val listaCarrinho = carrinho.carrinho

    @Test
    fun verificaSeProdutoExisteNoCarrinho(){
        val produto = Produto("X-burger","Lanche",10.0)
        carrinho.adicionarProduto(produto,3)
        Assertions.assertEquals(produto,carrinho.produtoExiste(produto.codigo))
    }
    @Test
    fun verificaProdutoNaoExistenteNoCarrinhoERetornaNulo(){
        val produto = Produto("X-burger","Lanche",10.0)
        Assertions.assertNull(carrinho.produtoExiste(produto.codigo))
    }
    @Test
    fun verificaSeProdutoEstaSendoAdicionadoAoCarrinho(){
        val produto = Produto("X-burger","Lanche",10.0)
        carrinho.adicionarProduto(produto,3)
        Assertions.assertTrue(listaCarrinho.containsKey(produto))
    }
    @Test
    fun verificaSeProdutoEstaSendoRemovidoDoCarrinho(){
        val produto = Produto("X-burger","Lanche",10.0)
        carrinho.retirarProdutoCarrinho(produto)
        Assertions.assertFalse(listaCarrinho.containsKey(produto))
    }
    @Test
    fun verificaSeValorTotalDoCarrinhoEstaCorreto(){
        val produto = Produto("X-burger","Lanche",10.0)
        carrinho.adicionarProduto(produto,3)
        Assertions.assertEquals(30.0,carrinho.calculaTotal())
    }

    @Test
    fun verificaSeQuantidadeEstaSendoAtualizada(){
        val produto = Produto("X-burger","Lanche",10.0)
        carrinho.adicionarProduto(produto,3)
        carrinho.atualizarQuantidade(produto,5)
        Assertions.assertEquals(5,listaCarrinho[produto])
    }

}