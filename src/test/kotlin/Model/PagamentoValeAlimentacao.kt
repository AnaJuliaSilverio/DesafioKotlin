package Model

import Utils.VerificaInputs
import com.github.ajalt.mordant.rendering.TextColors
import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.time.format.DateTimeParseException
import java.util.zip.DataFormatException

class PagamentoValeAlimentacao():Pagamento {
    lateinit var numeroCartao: String
    lateinit var dataValidade: LocalDate
    var valor = 0.0

    override fun efetuarPagamento(valor:Double) {
        while (true){
            try {
                println("Digite o número do cartão: ")
                numeroCartao = readln()
                VerificaInputs.verificaNumeroCartao(numeroCartao)
                println("Digite a data de validade do cartão: ")
                dataValidade = LocalDate.parse(readln(),VerificaInputs.formatter)
                if (dataValidade.isBefore(LocalDate.now())) throw IllegalArgumentException(TextColors.red("❌ Data inválida"))
                VerificaInputs.t.println(TextColors.green("✅ Pagamento com vale realizado com sucesso\n"))
                this.valor = valor
                break
            }catch (erro: IllegalArgumentException){
                println(erro.message)
            }catch (erro:DateTimeParseException){
                VerificaInputs.t.println(TextColors.red("❌ Data inválida"))
            }
        }
    }
}