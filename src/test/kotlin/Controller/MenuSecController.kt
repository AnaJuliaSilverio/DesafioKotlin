package Controller

import Model.*
import Repository.Carrinho
import Utils.VerificaInputs
import com.github.ajalt.mordant.rendering.TextColors
import view.Menus
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import kotlin.system.exitProcess

class MenuSecController(var carrinho: Carrinho,var nome:String){
    fun menuSecAtualizar(){
        while (true){
            try {
                Menus.carrinho(carrinho)
                println("Digite o código desejado ⬇\uFE0F")
                val produto = carrinho.produtoExiste(readln().toInt())
                if (produto != null) {
                    println("Digite a nova quantidade: ")
                    carrinho.atualizarQuantidade(produto, readln().toInt())
                    VerificaInputs.t.println(TextColors.green("✅ Produto atualizado\n"))
                    break
                } else {
                    VerificaInputs.t.println(TextColors.red("❌ Código do produto inválido\n"))
                }
            }catch (erro:NumberFormatException){
                println((TextColors.red("❌ Formato inválido,informe um valor numérico.")))
            }

        }
    }
    fun menuSecRemovProd(){
        while (true){
           try {
               Menus.carrinho(carrinho)
               println("Digite o código do produto a ser removido ⬇\uFE0F")
               val produto = carrinho.produtoExiste(readln().toInt())
               if (produto != null) {
                   carrinho.retirarProdutoCarrinho(produto)
                   VerificaInputs.t.println(TextColors.green("✅ Produto removido\n"))
                   break
               } else {
                   VerificaInputs.t.println(TextColors.red("❌ Código do produto inválido\n"))
               }
           }catch (erro:NumberFormatException){
               println((TextColors.red("❌ Formato inválido,informe um valor numérico.")))
           }
        }
    }
    fun menuSecFinalizar(){
        while (true){
            try {
                if (carrinho.carrinho.isEmpty()){
                    println(TextColors.red("❗ O carrinho está vázio. Adicione algo antes de finalizar"))
                    return
                }
                else{
                    Menus.menuPagamento()
                    println("Digite a forma de pagamento ⬇\uFE0F")
                    val pagamentoOpcao = readln()
                    VerificaInputs.verificaOpcaoMenuSec(pagamentoOpcao)
                    val formaPagamento: Pagamento? = when (pagamentoOpcao) {
                        "1" -> PagamentoCartaoCredito()
                        "2" -> PagamentoCartaoDebito()
                        "3" -> PagamentoValeAlimentacao()
                        "4" -> PagamentoDinheiro()
                        else -> null
                    }

                    formaPagamento?.efetuarPagamento(carrinho.calculaTotal())
                    Menus.notaFiscal(carrinho, nome, formaPagamento!!)
                    exitProcess(0)
                }



            }catch (erro: IllegalArgumentException){
                println(erro.message)
            }
        }
    }
}