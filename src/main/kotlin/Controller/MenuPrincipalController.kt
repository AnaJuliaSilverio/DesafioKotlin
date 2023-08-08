package Controller

import Repository.Carrinho
import Repository.ProdutoRepository
import Utils.VerificaInputs
import com.github.ajalt.mordant.rendering.TextColors
import view.Menus
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class MenuPrincipalController(private var carrinhoController:CarrinhoController){
    private var opcaoMenu:String = ""
    private var quantidade = 0
    fun menuPrincipal(){
        println("Digite a opção desejada ⬇\uFE0F: \n")
        opcaoMenu = readln()
        VerificaInputs.verificaOpcao(opcaoMenu)
        println("Digite a quatidade desejada ⬇\uFE0F:")
        quantidade = readln().toInt()
        VerificaInputs.verificaQuantidade(quantidade)

    }
    fun menuPrincipalLanches(){
        while (true){
            try {
                Menus.menuLanche()
                menuPrincipal()
                carrinhoController.adicionarProduto(opcaoMenu.toInt(),quantidade,"Lanche")
                println(TextColors.green("✅ Lanche Adicionado com sucesso\n"))
                Menus.carrinho(carrinhoController.carrinho )
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
                menuPrincipal()
                carrinhoController.adicionarProduto(opcaoMenu.toInt(),quantidade,"Bebida")
                println(TextColors.green("✅ Bebida adicionada com sucesso\n"))
                Menus.carrinho(carrinhoController.carrinho )
                break
            }catch (erro: NumberFormatException){
                println((TextColors.red("❌ Formato inválido,informe um valor numérico.")))
            }
            catch (erro: IllegalArgumentException){
                println(erro.message)
            }

        }
    }

}