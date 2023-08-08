package Strategy

interface PagamentoStrategy {
    fun coletarDados(totalPedido:Double)
    var totalPedido:Double
}