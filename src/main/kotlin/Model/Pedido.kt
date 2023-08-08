package Model
import Strategy.PagamentoStrategy

data class Pedido (val carinhho: Map<Produto, Int>,val nomeCliente:String,val pagamentoStrategy:PagamentoStrategy)
