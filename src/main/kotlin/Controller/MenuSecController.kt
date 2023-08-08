package Controller

import Model.*
import Repository.Carrinho
import Repository.ProdutoRepository
import Strategy.*
import Utils.VerificaInputs
import com.github.ajalt.mordant.rendering.TextColors
import view.Menus
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import kotlin.system.exitProcess

class MenuSecController(var carrinhoController: CarrinhoController,val processadorPagamentoController: ProcessadorPagamentoController, produtoRepository: ProdutoRepository){
    fun menuSecAtualizar(){
        while (true){
            try {
                Menus.carrinho(carrinhoController.carrinho)
                println("Digite o código desejado ⬇\uFE0F")
                val codigoProduto = readln().toInt()
                println("Digite a nova quantidade: ")
                val quantidade = readln().toInt()
                carrinhoController.atualizarCarrinho(codigoProduto,quantidade)
                break
            }catch (erro:NumberFormatException){
                println((TextColors.red("❌ Formato inválido,informe um valor numérico.")))
            }catch (erro:IllegalArgumentException){
                println(erro.message)
            }

        }
    }
    fun menuSecRemovProd(){
        while (true){
           try {
               Menus.carrinho(carrinhoController.carrinho)
               println("Digite o código do produto a ser removido ⬇\uFE0F")
               val codigoProduto = readln().toInt()
                carrinhoController.removerProdutoCarrinho(codigoProduto)
               break
           }catch (erro:NumberFormatException){
               println((TextColors.red("❌ Formato inválido,informe um valor numérico.")))
           }catch (erro:IllegalArgumentException){
               println(erro.message)
           }
        }
    }
    fun menuSecFinalizar(){
        while (true){
            try {
                finzalizarCarrinhoVazio()
                Menus.menuPagamento()
                println("Digite a forma de pagamento ⬇\uFE0F")
                val pagamentoOpcao = readln()
                VerificaInputs.verificaOpcaoMenuSec(pagamentoOpcao)
                processadorPagamentoController.processarPagamento(pagamentoOpcao)
            }catch (erro: IllegalArgumentException){
                println(erro.message)
            }
        }
    }
    fun finzalizarCarrinhoVazio(){
        if (carrinhoController.carrinho.carrinho.isEmpty()){
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

}