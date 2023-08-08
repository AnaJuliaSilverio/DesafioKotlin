package Strategy

import Model.Dinheiro
import Utils.VerificaInputs
import com.github.ajalt.mordant.rendering.TextColors
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class PagamentoDinheiro:PagamentoStrategy {
    lateinit var dinheiro:Dinheiro
    override var totalPedido: Double = 0.0
    override fun coletarDados(totalPedido: Double) {
        while (true){
            try {
                val valorRecebido = getValorRecebido()
                val troco = valorRecebido-totalPedido
                VerificaInputs.verificaPreco(troco)
                println(TextColors.green("✅ Pagamento com dinheiro realizado com sucesso\n"))
                this.totalPedido =totalPedido
                dinheiro = Dinheiro(troco, valorRecebido)
                break
            }catch (erro: NumberFormatException){
                println((TextColors.red("❌ Formato inválido,informe um valor numérico.")))
            }
            catch (erro: IllegalArgumentException){
                println((TextColors.red("❌ Quantidade inválida,o valor do seu pedido é de R$%.2f".format(totalPedido))))
            }
        }
    }

    fun getValorRecebido():Double{
        println("Qual valor em dinheiro deseja pagar?")
        val valorRecebido = readln().toDouble()
        VerificaInputs.verificaPreco(valorRecebido-totalPedido)
        return valorRecebido
    }
}