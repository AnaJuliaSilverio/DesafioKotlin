package Controller

import Model.Pedido
import Repository.Carrinho
import Strategy.*
import view.Menus
import kotlin.system.exitProcess

class ProcessadorPagamentoController(val carrinho: Carrinho,val nome:String){
    fun processarPagamento(opcao: String){
        val formaPagamento: PagamentoStrategy?= criarFormaPagamento(opcao)
        formaPagamento?.coletarDados(carrinho.calculaTotal())
        val pedido = Pedido(carrinho.carrinho,nome,formaPagamento!!)
        Menus.notaFiscal(pedido)
        exitProcess(0)
    }

     fun criarFormaPagamento(opcao:String):PagamentoStrategy?{
        return when (opcao) {
            "1" -> PagamentoCartaoCredito()
            "2" -> PagamentoCartaoDebito()
            "3" -> PagamentoValeAlimentacao()
            "4" -> PagamentoDinheiro()
            else -> null
        }
    }
}