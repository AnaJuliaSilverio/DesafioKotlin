package Model

import Utils.VerificaInputs
import com.github.ajalt.mordant.rendering.TextColors
import java.lang.IllegalArgumentException

data class CartaoDebito(var numeroCartao: String,var cvv: String)