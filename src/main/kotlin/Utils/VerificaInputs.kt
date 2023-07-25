package Utils

import com.github.ajalt.mordant.rendering.TextColors
import com.github.ajalt.mordant.terminal.Terminal
import java.lang.IllegalArgumentException
import java.time.format.DateTimeFormatter

class VerificaInputs {
    companion object{
        val t = Terminal()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        fun verificaOpcao(opcao:String){
            val regex = Regex("^\\d+$")
            if (!regex.matches(opcao)) throw IllegalArgumentException((TextColors.red("❌ Formato inválido, para escolher o item, você deve informar o número dele.")))
            else if (opcao!="1"&&opcao!="2"){
                throw IllegalArgumentException(TextColors.red("❗ Opção inválida, tente novamente"))
            }
        }
        fun verificaOpcaoMenuSec(opcao:String){
            val regex = Regex("^\\d+$")
            if (!regex.matches(opcao)) throw IllegalArgumentException((TextColors.red("❌ Formato inválido, para escolher o item, você deve informar o número dele.")))
            else if (opcao!="1"&&opcao!="2"&&opcao!="3"&&opcao!="4"){
                throw IllegalArgumentException(TextColors.red("❗ Opção inválida, tente novamente"))
            }
        }
        fun verificaQuantidade(qtd:Int){
            if (qtd<=0) throw IllegalArgumentException((TextColors.red("❌ Quantidade deve ser superior a zero")))
        }

        fun verificaNumeroCartao(numeroCartao: String){
            val numeroCartaoSemEspaco = numeroCartao.replace(" ","")
            if (numeroCartaoSemEspaco.length != 16) {
                throw IllegalArgumentException((TextColors.red("❌ Número do cartão inválido")))
            }
            if (!numeroCartaoSemEspaco.matches("\\d+".toRegex())) {
                throw IllegalArgumentException((TextColors.red("❌ Número do cartão inválido")))
            }
            var sum = 0
            var doubleDigit = false
            for (i in numeroCartaoSemEspaco.length - 1 downTo 0) {
                var digit = Character.getNumericValue(numeroCartaoSemEspaco[i])
                if (doubleDigit) {
                    digit *= 2
                    if (digit > 9) {
                        digit = digit % 10 + 1
                    }
                }
                sum += digit
                doubleDigit = !doubleDigit
            }
            if (sum % 10 != 0) throw IllegalArgumentException((TextColors.red("❌ Número do cartão inválido")))
        }
        fun verificaCvv(cvv: String){
            if (cvv.length != 3) {
                throw IllegalArgumentException((TextColors.red("❌ Número do CVV inválido")))
            }
            if (!(cvv.matches("\\d+".toRegex())))throw IllegalArgumentException((TextColors.red("❌ Número do CVV inválido")))

        }
    }
}