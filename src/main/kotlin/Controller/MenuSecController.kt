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
                    val quantidade = readln().toInt()
                    VerificaInputs.verificaQuantidade(quantidade)
                    carrinho.atualizarQuantidade(produto, quantidade)
                    VerificaInputs.t.println(TextColors.green("✅ Produto atualizado\n"))
                    Menus.carrinho(carrinho)
                    break
                } else {
                    VerificaInputs.t.println(TextColors.red("❌ Código do produto inválido\n"))
                }
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
               Menus.carrinho(carrinho)
               println("Digite o código do produto a ser removido ⬇\uFE0F")
               val produto = carrinho.produtoExiste(readln().toInt())
               if (produto != null) {
                   carrinho.retirarProdutoCarrinho(produto)
                   VerificaInputs.t.println(TextColors.green("✅ Produto removido\n"))
                   Menus.carrinho(carrinho)
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
                    println(TextColors.red("❗ O carrinho está vázio. Deseja adicionar algo antes de finalizar?"))
                    println("1\uFE0F⃣ -Sim")
                    println("2\uFE0F⃣ -Não\n")
                    val resposta = readln()
                    VerificaInputs.verificaOpcao(resposta)
                    if (resposta=="1") return
                    else {
                        VerificaInputs.t.println(TextColors.magenta("Te vejo na próxima \uD83D\uDE04 Tchau,tchau"))
                        exitProcess(0)
                    }

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