# Totem de Auto-Atendimento para Lanchonete FastFood - Desafio em Kotlin

Este projeto implementa um sistema de totem de auto-atendimento para uma lanchonete FastFood, com o objetivo de permitir que os clientes façam seus pedidos de forma autônoma, liberando as operadoras de caixa para outras funções. O totem permite que o cliente escolha entre lanches e bebidas, selecione a quantidade desejada, visualize o carrinho de compras com o valor total e tenha a opção de incluir mais itens, editar, remover itens ou finalizar o pedido com diferentes formas de pagamento.


## Requisitos

1. Ao iniciar o programa, o totem de auto-atendimento exibirá um menu inicial com as opções:

    1. Comprar Lanche
    2. Comprar Bebida

2. Digite o número correspondente à opção desejada.

3. Caso a entrada seja inválida (não seja um número ou esteja fora do intervalo válido), o sistema mostrará a mensagem "Opção inválida, tente novamente" e exibirá novamente o menu inicial.

4. Se você escolher "Comprar Lanche" (digitar 1), o totem exibirá as opções:

    1. X-burger
    2. X-salada

5. Digite o número correspondente ao lanche que deseja comprar.

6. Caso a entrada seja inválida (não seja um número ou esteja fora do intervalo válido), o sistema mostrará a mensagem "Formato inválido, para escolher o item, você deve informar o número dele" e exibirá novamente o menu inicial de lanches.

7. Em seguida, o sistema perguntará a quantidade do lanche que deseja comprar.

8. Após escolher a quantidade, o carrinho de compras será atualizado, mostrando o código, quantidade, nome e valor do lanche selecionado, bem como o valor total do pedido até aquele momento.

9. Se você escolher "Comprar Bebida" (digitar 2), o totem exibirá as opções:

    1. Refrigerante
    2. Suco

10. Digite o número correspondente à bebida que deseja comprar.

11. Caso a entrada seja inválida (não seja um número ou esteja fora do intervalo válido), o sistema mostrará a mensagem "Formato inválido, para escolher o item, você deve informar o número dele" e exibirá novamente o menu inicial de bebidas.

12. Em seguida, o sistema perguntará a quantidade de bebida que deseja comprar.

13. Após escolher a quantidade, o carrinho de compras será atualizado, mostrando o código, quantidade, nome e valor da bebida selecionada, bem como o valor total do pedido até aquele momento.

14. Após adicionar os itens ao carrinho, o sistema perguntará se você deseja:

    a. Comprar mais itens: o sistema retornará ao menu inicial.
    b. Editar um item: o sistema solicitará o código do produto que deseja editar e a nova quantidade desejada. Em seguida, o carrinho de compras será atualizado.
    c. Remover um item: o sistema solicitará o código do produto que deseja remover e exibirá o carrinho de compras atualizado.
    d. Finalizar o pedido: o sistema mostrará o valor total do pedido e a lista de itens selecionados. Em seguida, perguntará a forma de pagamento, aceitando cartão de crédito, cartão de débito, vale refeição e dinheiro.

        i. Se você selecionar uma das opções de cartão de crédito, cartão de débito ou vale refeição, o sistema mostrará a mensagem "Compra finalizada com sucesso! Boa refeição".

        ii. Se você selecionar "dinheiro", o sistema solicitará o valor em dinheiro que deseja pagar. Se o valor for maior que o valor total da compra, o sistema mostrará o troco que você receberá.

        iii. Caso a entrada seja inválida (não seja um número ou esteja fora das opções válidas), o sistema mostrará a mensagem "Opção inválida, tente novamente" e exibirá novamente as opções de cartão de crédito, cartão de débito, vale refeição e dinheiro.

## Pacote Utils

Este pacote tem como finalidade verificar os inputs recebidos e lançar exceções quando necessário.Suas funções são:
    a. fun verificaOpcao(opcao:String) e verificaOpcaoMenuSec(opcao:String): verifica se o input está dentro do esperado do Menu
    b. val formatter: DateTimeFormatter: coloca data no formato dd/mm/aaaa
    c. fun verificaNumeroCartao(numeroCartao: String): verifica o número do cartão de crédito de acordo com o algoritmo de Luhn
    d. fun verificaCvv(cvv: String): verifica se o cvv está dentro do esperado(apenas 3 digitos sendo todos números)

## View Menus

Para conseguir realizar a personalização do console, fiz o uso de uma dependencia chamada mordant. Basicamente nesse pacote estão presentes
meus menus com emojis e tabelas para carrinho e nota fiscal.

