package ContrellerTest

import Controller.MenuController
import Controller.MenuPrincipalController
import Controller.MenuSecController
import Repository.Carrinho
import Repository.ProdutoRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoSettings
import java.io.ByteArrayInputStream
import java.lang.RuntimeException

@MockitoSettings
class MenuControllerTest {

    private lateinit var menuController: MenuController
    private lateinit var carrinho: Carrinho
    private lateinit var produtoRepository: ProdutoRepository
    private lateinit var menuPrincipalController: MenuPrincipalController
    private lateinit var menuSecController: MenuSecController

    @BeforeEach
    fun setUp() {
        carrinho = mock(Carrinho::class.java)
        produtoRepository = mock(ProdutoRepository::class.java)
        menuPrincipalController = mock(MenuPrincipalController::class.java)
        menuSecController = mock(MenuSecController::class.java)
        menuController = MenuController("Nome do Menu")
        menuController.carrinho = carrinho
        menuController.produtoRepository = produtoRepository
        menuController.menuPrincipalController = menuPrincipalController
        menuController.menuSecController = menuSecController
    }

    @Test
    fun testMenuPrincipalOpcao1ChamaMenuPrincipalLanches() {
        val input = "1"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        menuController.menuPrincipal()
        verify(menuPrincipalController).menuPrincipalLanches()
    }
    @Test
    fun testMenuPrincipalOpcao2ChamaMenuPrincipalBebidas() {
        val input = "2"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        menuController.menuPrincipal()
        verify(menuPrincipalController).menuPrincipalBebidas()
    }
    @Test
    fun testMenuPrincipalOpcaoInvalidaLancaExecao() {
        val input = "3"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(RuntimeException::class.java) {
            menuController.menuPrincipal()
        }
    }
    @Test
    fun testMenuPrincipalOpcaoValorNaoNumerioLancaExecao() {
        val input = "a"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(RuntimeException::class.java) {
            menuController.menuPrincipal()
        }
    }


    @Test
    fun testMenuSecundarioOpcao2ChamaMenuSecAtualizar() {
        val input = "2"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(RuntimeException::class.java) {
            menuController.menuSecundario()
        }
        verify(menuSecController, times(1)).menuSecAtualizar()
    }
    @Test
    fun testMenuSecundarioOpcao4ChamaFinalizar() {
        val input = "4"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(RuntimeException::class.java) {
            menuController.menuSecundario()
        }
        verify(menuSecController, times(1)).menuSecFinalizar()
    }
    @Test
    fun testMenuSecundarioOpcaoInvalida() {
        val input = "5"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(RuntimeException::class.java) {
            menuController.menuSecundario()
        }
    }
    @Test
    fun testMenuSecundarioOpcaoInvalidaNaoNumerica() {
        val input = "a"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        Assertions.assertThrows(RuntimeException::class.java) {
            menuController.menuSecundario()
        }
    }
}
