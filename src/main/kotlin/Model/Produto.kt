package Model

class Produto(var nome:String,var categoria:String,var preco:Double) {
    companion object{
        private var proximoCodigo = 1000
    }
    val codigo:Int = proximoCodigo++
}