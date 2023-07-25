package view
import Model.Pagamento
import Model.PagamentoDinheiro
import Repository.Carrinho
import Utils.VerificaInputs
import com.github.ajalt.mordant.rendering.BorderType.Companion.SQUARE_DOUBLE_SECTION_SEPARATOR
import com.github.ajalt.mordant.rendering.TextAlign.*
import com.github.ajalt.mordant.rendering.TextAlign.LEFT
import com.github.ajalt.mordant.rendering.TextAlign.RIGHT
import com.github.ajalt.mordant.rendering.TextColors.*
import com.github.ajalt.mordant.rendering.TextStyle
import com.github.ajalt.mordant.table.Borders
import com.github.ajalt.mordant.table.Borders.*
import com.github.ajalt.mordant.table.table
import com.github.ajalt.mordant.terminal.Terminal
import java.time.LocalDate

class Menus {

    companion object {
        fun carrinho(carrinho: Carrinho) {
            val terminal = Terminal()
            val tableNota = table {
                borderType = SQUARE_DOUBLE_SECTION_SEPARATOR
                align = CENTER
                column(0) {
                    align = LEFT
                }
                header {
                    cellBorders = Borders.NONE
                    style = TextStyle(bold = true)
                    row("            \uD83D\uDED2Carrinho")
                }
                body {
                    row { }
                }

            }
            val table = table {
                borderType = SQUARE_DOUBLE_SECTION_SEPARATOR
                column(0) {
                    align = LEFT
                }
                column(3) {
                    align = RIGHT
                }

                header {
                    cellBorders = Borders.NONE
                    align = LEFT
                    style = TextStyle(bold = true)
                    style = magenta
                    row("Código", "  Itens", "  Preço", " Quantidade")
                }
                body {
                    cellBorders = TOP_BOTTOM
                    column(0) {
                        cellBorders = TOP_BOTTOM
                    }
                    for (item in carrinho.carrinho.keys) {
                        row(red("${item.codigo}"), item.nome, "R$%.2f".format(item.preco
                        ), carrinho.carrinho[item])
                    }
                }
                footer {
                    cellBorders = BOTTOM
                    align = RIGHT
                    row {

                        cell("Total")
                        cell(yellow("R$%.2f".format(carrinho.calculaTotal()))) {
                            columnSpan = 3
                        }
                    }
                }

            }
            terminal.println(tableNota)
            terminal.println(table)
        }

        fun notaFiscal(carrinho: Carrinho,nome:String,pagamento: Pagamento) {
            val terminal = Terminal()
            val tableNota = table {
                borderType = SQUARE_DOUBLE_SECTION_SEPARATOR
                align = CENTER
                column(0) {
                    align = LEFT
                }
                header {
                    cellBorders = Borders.NONE
                    style = TextStyle(bold = true)
                    row("              Nota fiscal")
                }
                body {
                    cellBorders = BOTTOM
                    row { }
                    row("${magenta("Nome:")} $nome            ${magenta("Data: ")}${LocalDate.now().format(VerificaInputs.formatter)}")
                }



            }
            val table = table {
                borderType = SQUARE_DOUBLE_SECTION_SEPARATOR
                align = RIGHT
                column(0) {
                    align = LEFT
                }
                header {
                    cellBorders = Borders.NONE
                    align = LEFT
                    style = TextStyle(bold = true)
                    style = magenta
                    row("Itens", "  Preço", "        Quantidade")
                }
                body {
                    cellBorders = TOP_BOTTOM
                    column(0) {
                        cellBorders = TOP_BOTTOM
                    }
                    for (item in carrinho.carrinho.keys) {
                        row( item.nome, "R$%.2f".format(item.preco
                        ), carrinho.carrinho[item])
                    }
                    row {  }
                }
                footer {
                    cellBorders = TOP_BOTTOM
                    row {
                        cell("Total")
                        cell(yellow("R$%.2f".format(carrinho.calculaTotal()))) {
                            columnSpan = 3
                        }
                    }
                    if (pagamento is PagamentoDinheiro){
                        row {
                            cell("Valor Pago")
                            cell(yellow("R$%.2f".format(pagamento.valorRecebido))){
                                columnSpan = 3
                            }
                        }
                        row {
                            cell("Troco")
                            cell(yellow("R$%.2f".format(pagamento.troco))){
                                columnSpan = 3
                            }
                        }
                    }


                }

            }
            terminal.println(tableNota)
            terminal.println(table)
        }

        fun menuLanche() {
            val terminal = Terminal()
            val tablemMenu = table {
                borderType = SQUARE_DOUBLE_SECTION_SEPARATOR
                align = CENTER
                column(0) {
                    align = LEFT
                }
                header {
                    cellBorders = Borders.NONE
                    style = TextStyle(bold = true)
                    row("               \uD83C\uDF7D\uFE0F MENU")
                }
                body {
                    cellBorders = BOTTOM
                }

            }
            val tableLanches = table {
                borderType = SQUARE_DOUBLE_SECTION_SEPARATOR
                align = RIGHT
                column(0) {
                    align = LEFT
                }
                header {
                    cellBorders = Borders.NONE
                    align = LEFT
                    style = TextStyle(bold = true)
                    style = magenta
                    row("","Lanches", "               Preço")
                }
                body {
                    cellBorders = TOP_BOTTOM
                    column(0) {
                        cellBorders = TOP_BOTTOM
                    }
                    row("1️⃣","\uD83C\uDF54 X-Burger", " R$10,00")
                    row("2\uFE0F⃣","\uD83E\uDD6A X-Salada", " R$12,00")
                }
            }
            terminal.println(tablemMenu)
            terminal.println(tableLanches)
        }

        fun menuBebida() {
            val terminal = Terminal()
            val tablemMenu = table {
                borderType = SQUARE_DOUBLE_SECTION_SEPARATOR

                column(0) {
                    align = LEFT
                }

                header {
                    cellBorders = Borders.NONE
                    style = TextStyle(bold = true)
                    row("               \uD83C\uDF7D\uFE0F MENU")
                }
                body {
                    cellBorders = BOTTOM
                }

            }
            val tableBebidas = table {
                borderType = SQUARE_DOUBLE_SECTION_SEPARATOR

                column(0) {
                    align = LEFT
                }
                column(3) {
                    align = RIGHT
                }
                header {
                    cellBorders = Borders.NONE
                    align = LEFT
                    style = TextStyle(bold = true)
                    style = magenta
                    row("","Bebidas", "               Preço")
                }
                body {
                    cellBorders = TOP_BOTTOM
                    column(0) {
                        cellBorders = TOP_BOTTOM
                    }

                    row("1\uFE0F⃣ ","\uD83E\uDD64 Refrigerante", " R$8,00")
                    row("2\uFE0F⃣","\uD83E\uDDC3 Suco", " R$6,00")
                }
            }
            terminal.println(tablemMenu)
            terminal.println(tableBebidas)
        }

        fun menuPrincipal() {

            println("1\uFE0F⃣-Lanches")
            println("2\uFE0F⃣ -Bebidas\n")
        }
        fun menuSecundario(){
            println("1\uFE0F⃣-Adicionar mais itens \uD83D\uDED2")
            println("2\uFE0F⃣-Editar Item ✏\uFE0F")
            println("3\uFE0F⃣-Remover Item \uD83D\uDDD1\uFE0F")
            println("4\uFE0F⃣-Finalizar Pedido ✅\n")
        }
        fun menuPagamento(){
            println("\u0031\uFE0F\u20E3-Cartão de crédito \uD83D\uDCB3")
            println("2\uFE0F⃣-Cartão de débito  \uD83D\uDCB3")
            println("3\uFE0F⃣-Vale alimentação \uD83D\uDCB3")
            println("4\uFE0F⃣-Dinheiro \uD83D\uDCB5\n")
        }

    }
}