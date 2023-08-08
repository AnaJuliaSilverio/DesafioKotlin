package Strategy

import Model.ValeAlimentacao
import Utils.VerificaInputs
import com.github.ajalt.mordant.rendering.TextColors
import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.time.format.DateTimeParseException

class PagamentoValeAlimentacao:PagamentoStrategy {
    lateinit var valeAlimentacao:ValeAlimentacao
    override var totalPedido: Double = 0.0
    override fun coletarDados(totalPedido: Double) {
        while (true){
            try {
                val numeroCartao = getNumeroCartao()
                val dataValidade = getDataValidade()
                println(TextColors.green("✅ Pagamento com vale realizado com sucesso\n"))
                this.totalPedido =totalPedido
                valeAlimentacao = ValeAlimentacao(numeroCartao, dataValidade)
                break
            }catch (erro: IllegalArgumentException){
                println(erro.message)
            }catch (erro: DateTimeParseException){
                VerificaInputs.t.println(TextColors.red("❌ Data inválida"))
            }
        }
    }

    fun getNumeroCartao():String{
        println("Digite o número do cartão: ")
        val numeroCartao = readln()
        VerificaInputs.verificaNumeroCartao(numeroCartao)
        return numeroCartao
    }
    fun getDataValidade():LocalDate{
        println("Digite a data de validade do cartão: ")
        val dataValidade = LocalDate.parse(readln(), VerificaInputs.formatter)
        if (dataValidade.isBefore(LocalDate.now())) throw IllegalArgumentException(TextColors.red("❌ Data inválida"))
        return dataValidade
    }
}