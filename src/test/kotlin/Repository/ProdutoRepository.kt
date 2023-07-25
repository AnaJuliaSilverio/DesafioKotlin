package Repository

import Model.Produto

class ProdutoRepository {
    private val lanches = arrayListOf(
        Produto("X-burger","Lanche",10.0),
        Produto("X-Salada","Lanche",12.00),

    )
    private val bebidas = arrayListOf(
        Produto("Refrigente","Bebida",8.0),
        Produto("Suco","Bebida",6.00))

    fun retornaLanche(codigo:Int):Produto{
        return lanches[codigo-1]
    }
    fun retornaBebidas(codigo: Int):Produto{
        return bebidas[codigo-1]
    }
}