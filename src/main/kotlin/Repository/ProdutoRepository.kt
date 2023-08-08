package Repository

import Model.Produto

class ProdutoRepository {
    private val produtos = arrayListOf(
        Produto("X-burger", "Lanche", 10.0),
        Produto("X-Salada", "Lanche", 12.00),
        Produto("Refrigente", "Bebida", 8.0),
        Produto("Suco", "Bebida", 6.00)
    )

    fun retornaProduto(codigo: Int, tipo: String): Produto {
        val produtosDoTipo = produtos.filter { it.categoria == tipo }
        return produtosDoTipo[codigo - 1]
    }
}