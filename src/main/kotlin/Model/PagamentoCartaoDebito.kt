package Model

import Utils.VerificaInputs
import com.github.ajalt.mordant.rendering.TextColors
import java.lang.IllegalArgumentException

class PagamentoCartaoDebito():Pagamento {
    lateinit var numeroCartao: String
    lateinit var cvv: String
    var valor = 0.0
    override fun efetuarPagamento(valor:Double) {
            while (true){
                try {
                    println("Digite o número do cartão: ")
                    numeroCartao = readln()
                    VerificaInputs.verificaNumeroCartao(numeroCartao)
                    println("Digite o CVV do cartão: ")
                    cvv = readln()
                    VerificaInputs.verificaCvv(cvv)
                    VerificaInputs.t.println(TextColors.green("✅ Pagamento com cartão débito realizado com sucesso\n"))
                    this.valor = valor
                    break
                }catch (erro: IllegalArgumentException){
                    println(erro.message)
                }
            }

    }


}