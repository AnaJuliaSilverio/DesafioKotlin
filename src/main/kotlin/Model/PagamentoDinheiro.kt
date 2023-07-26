package Model

import Utils.VerificaInputs
import com.github.ajalt.mordant.rendering.TextColors
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class PagamentoDinheiro:Pagamento {
    var troco = 0.0
    var valor = 0.0
    var valorRecebido = 0.0

    override fun efetuarPagamento(valor: Double) {
        while (true){
            try {
                println("Qual valor em dinheiro deseja pagar?")
                valorRecebido = readln().toDouble()
                VerificaInputs.verificaPreco(valorRecebido-valor)
                troco = valorRecebido-valor
                VerificaInputs.t.println(TextColors.green("✅ Pagamento com dinheiro realizado com sucesso\n"))
                this.valor = valor
                break
            }catch (erro: NumberFormatException){
                println((TextColors.red("❌ Formato inválido,informe um valor numérico.")))
            }
            catch (erro:IllegalArgumentException){
                println((TextColors.red("❌ Quantidade inválida,o valor do seu pedido é de R$%.2f".format(valor))))
            }
        }

    }

}
