import Controller.*
import Repository.Carrinho
import Repository.ProdutoRepository
import Utils.VerificaInputs
import com.github.ajalt.mordant.rendering.TextColors

fun main() {
    VerificaInputs.t.println(TextColors.magenta("Bem-vindo(a) ao UaiFood \uD83D\uDE04\n"))
    println("Digite seu nome ⬇\uFE0F")
    val nome = readln()
    println("Olá, $nome \uD83D\uDE4B\uD83C\uDFFE\u200D♀\uFE0F Vamos ao pedido \uD83D\uDE0B\n")
    val carrinho = Carrinho()
    val produtoRepository = ProdutoRepository()
    val carrinhoController = CarrinhoController(carrinho, produtoRepository)
    val processadorPagamentoController = ProcessadorPagamentoController(carrinho,nome)
    val menuPrincipalController = MenuPrincipalController(carrinhoController)
    val menuSecController = MenuSecController(carrinhoController,processadorPagamentoController,produtoRepository)
    val menus = MenuController(menuPrincipalController, menuSecController)
    menus.menuPrincipal()
    menus.menuSecundario()
}



