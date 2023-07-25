package Controller

import Repository.Carrinho
import Repository.ProdutoRepository
import Utils.VerificaInputs
import com.github.ajalt.mordant.rendering.TextColors
import view.Menus
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class MenuPrincipalController(var carrinho: Carrinho,var produtoRepository: ProdutoRepository){
    fun menuPrincipalLanches(){
        while (true){
            try {
                Menus.menuLanche()
                println("Digite a opção desejada ⬇\uFE0F: \n")
                val opcaoLanche = readln()
                VerificaInputs.verificaOpcao(opcaoLanche)
                val lanche = produtoRepository.retornaLanche(opcaoLanche.toInt())
                println("Digite a quatidade desejada ⬇\uFE0F:")
                val quantidade = readln().toInt()
                VerificaInputs.verificaQuantidade(quantidade)
                carrinho.adicionarProduto(lanche, quantidade)
                VerificaInputs.t.println(TextColors.green("✅ Lanche Adicionado com sucesso\n"))
                Menus.carrinho(carrinho)
                break
            }catch (erro: NumberFormatException){
                println((TextColors.red("❌ Formato inválido,informe um valor numérico.")))
            }
            catch (erro: IllegalArgumentException){
                println(erro.message)
            }
        }
    }
    fun menuPrincipalBebidas(){
        while (true){
            try {
                Menus.menuBebida()
                println("Digite a opção desejada ⬇\uFE0F: \n")
                val opcaoLanche = readln()
                VerificaInputs.verificaOpcao(opcaoLanche)
                val bebida = produtoRepository.retornaBebidas(opcaoLanche.toInt())
                println("Digite a quatidade desejada ⬇\uFE0F:")
                val quantidade = readln().toInt()
                VerificaInputs.verificaQuantidade(quantidade)
                carrinho.adicionarProduto(bebida, quantidade)
                VerificaInputs.t.println(TextColors.green("✅ Bebida Adicionado com sucesso\n"))
                Menus.carrinho(carrinho)
                break
            }catch (erro:NumberFormatException){
                println((TextColors.red("❌ Formato inválido,informe um valor numérico.")))
            }
            catch (erro: IllegalArgumentException){
                println(erro.message)
            }
        }
    }

}