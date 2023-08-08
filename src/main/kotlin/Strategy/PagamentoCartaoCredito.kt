package Strategy

import Model.CartaoCredito
import com.github.ajalt.mordant.rendering.TextColors
import java.lang.IllegalArgumentException

class PagamentoCartaoCredito :PagamentoStrategy,PagamentoCartao(){
    override var totalPedido: Double = 0.0

    lateinit var cartaoCredito:CartaoCredito
    override fun coletarDados(totalPedido:Double) {
        while (true){
            try {
                val numeroCartao = getNumeroCartao()
                val cvv = getCvv()
                println(TextColors.green("✅ Pagamento com cartão crédito realizado com sucesso\n"))
                cartaoCredito = CartaoCredito(numeroCartao, cvv)
                this.totalPedido=totalPedido
                break
            }catch (erro: IllegalArgumentException){
                println(erro.message)
            }
        }
    }
}