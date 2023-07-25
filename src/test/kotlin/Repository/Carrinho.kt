package Repository

import Model.Produto

class Carrinho {
    val carrinho = mutableMapOf<Produto, Int>()

    fun produtoExiste(codigoProduto: Int): Produto?{
        for (key in carrinho.keys){
            if (codigoProduto == key.codigo) return key
        }
        return null
    }
    fun adicionarProduto(produto: Produto, quantidade:Int){
        if (carrinho.containsKey(produto)){
            val qtdAntiga = carrinho[produto]
            if (qtdAntiga != null) {
                carrinho[produto] = qtdAntiga+quantidade
            }
        }else carrinho.put(produto,quantidade)
    }
    fun retirarProdutoCarrinho(produto: Produto){
        carrinho.remove(produto)
    }
    fun calculaTotal():Double{
        var total = 0.0
        for (item in carrinho.keys){
            total += (item.preco * carrinho[item]!!)
        }
        return total
    }
    fun atualizarQuantidade(produto: Produto,quantidade: Int){
        carrinho[produto] = quantidade
    }

}