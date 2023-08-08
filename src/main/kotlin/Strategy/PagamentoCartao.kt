package Strategy

import Utils.VerificaInputs

open class PagamentoCartao{
    fun getCvv():String{
        println("Digite o CVV do cartão: ")
        val cvv = readln()
        VerificaInputs.verificaCvv(cvv)
        return cvv
    }
    fun getNumeroCartao():String{
        println("Digite o número do cartão: ")
        val numeroCartao = readln()
        VerificaInputs.verificaNumeroCartao(numeroCartao)
        return numeroCartao
    }


}