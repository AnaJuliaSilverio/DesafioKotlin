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
    fun verificaCarrinhoVazio(){
        if (carrinho.carrinho.isEmpty()){
            println(TextColors.red("❗ O carrinho está vázio. Deseja adicionar algo antes de finalizar?"))
            println("1\uFE0F⃣ -Sim")
            println("2\uFE0F⃣ -Não\n")
            val resposta = readln()
            VerificaInputs.verificaOpcao(resposta)
            if (resposta=="1") return
            else {
                println(TextColors.magenta("Te vejo na próxima \uD83D\uDE04 Tchau,tchau"))
                exitProcess(0)
            }
        }
    }
    fun adicionarProduto(opcaoLanche:Int,quantidade: Int,categoria:String){
        val lanche = produtoRepository.retornaProduto(opcaoLanche,categoria)
        carrinho.adicionarProduto(lanche, quantidade)
    }
}