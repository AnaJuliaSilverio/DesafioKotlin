package Strategy

import Model.CartaoDebito
import com.github.ajalt.mordant.rendering.TextColors
import java.lang.IllegalArgumentException

class PagamentoCartaoDebito:PagamentoStrategy, PagamentoCartao() {
    lateinit var cartaoDebito:CartaoDebito
    override var totalPedido: Double = 0.0
    override fun coletarDados(totalPedido: Double) {
        while (true){
            try {
                val numeroCartao = getNumeroCartao()
                val cvv = getCvv()
                println(TextColors.green("✅ Pagamento com cartão débito realizado com sucesso\n"))
                this.totalPedido= totalPedido
                cartaoDebito = CartaoDebito(numeroCartao, cvv)
                break
            }catch (erro: IllegalArgumentException){
                println(erro.message)
            }
        }
    }

}