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
                carrinhoController.verificaCarrinhoVazio()
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

}