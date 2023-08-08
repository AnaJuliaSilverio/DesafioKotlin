package Controller

import Model.Produto
import Repository.Carrinho
import Repository.ProdutoRepository
import Utils.VerificaInputs
import com.github.ajalt.mordant.rendering.TextColors
import view.Menus
import java.lang.IllegalArgumentException
import kotlin.system.exitProcess

class CarrinhoController(val carrinho: Carrinho,val produtoRepository: ProdutoRepository){
    fun atualizarCarrinho(codigoProduto:Int,quantidade:Int){
        val produto = verificaCodigoProduto(codigoProduto)
        VerificaInputs.verificaQuantidade(quantidade)
        carrinho.atualizarQuantidade(produto, quantidade)
        println(TextColors.green("✅ Produto atualizado\n"))
        Menus.carrinho(carrinho)


    }
    fun verificaCodigoProduto(codigoProduto: Int): Produto {
        return carrinho.produtoExiste(codigoProduto)
            ?: throw IllegalArgumentException(TextColors.red("❌ Código do produto inválido\n"))
    }
    fun removerProdutoCarrinho(codigoProduto:Int){
        val produto = verificaCodigoProduto(codigoProduto)
        carrinho.retirarProdutoCarrinho(produto)
        println(TextColors.green("✅ Produto removido\n"))
    }

    fun adicionarProduto(opcaoLanche:Int,quantidade: Int,categoria:String){
        val lanche = produtoRepository.retornaProduto(opcaoLanche,categoria)
        carrinho.adicionarProduto(lanche, quantidade)
    }
}