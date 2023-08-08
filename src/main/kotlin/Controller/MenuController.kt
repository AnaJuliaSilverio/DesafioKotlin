package Controller

import Repository.Carrinho
import Repository.ProdutoRepository
import Utils.VerificaInputs
import view.Menus
import java.lang.IllegalArgumentException

class MenuController(val menuPrincipalController: MenuPrincipalController,val menuSecController: MenuSecController) {


    fun menuPrincipal() {
        while (true){
            println("Digite a opção desejada ⬇\uFE0F: \n")
            Menus.menuPrincipal()
            try {
                val opcao = readln()
                VerificaInputs.verificaOpcao(opcao)
                when (opcao) {
                    "1" -> menuPrincipalController.menuPrincipalLanches()
                    "2" ->menuPrincipalController.menuPrincipalBebidas()
                }
                break
            }catch (erro:IllegalArgumentException){
                println(erro.message)
            }
        }

    }
    fun menuSecundario() {
        while (true) {
            println("Digite a opção desejada ⬇\uFE0F: \n")
            Menus.menuSecundario()
            try {
                val opcao = readln()
                VerificaInputs.verificaOpcaoMenuSec(opcao)
                when (opcao) {
                    "1" -> menuPrincipal()
                    "2" -> menuSecController.menuSecAtualizar()
                    "3" -> menuSecController.menuSecRemovProd()
                    "4" -> menuSecController.menuSecFinalizar()
                }
            }catch (erro:IllegalArgumentException){
                println(erro.message)
            }
        }
    }
}