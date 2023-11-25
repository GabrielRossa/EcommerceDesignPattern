# EcommerceDesignPattern

## Os Design Patterns usados foram:

- Dependence Injection
- Singleton
- Observer

## Dependence Injection

Foi utilizado para fazer a troca de maneira flexível entre as duas formas de pagamento, no caso, foram escolhidos os métodos de Pix e PayPal. A injeção de dependência permite que as duas maneiras sejam utilizadas para fazer os pagamentos.

## Singleton

O Singleton foi implementado no carrinho de compras com o intuito de manter a instãncia do carrinho de compras sempre atualizado. A ideia é que independente da adição ou remoção dos itens ser feitas em qualquer local do código, a alteração será realizada no mesmo carrinho o tempo todo.
Isso foi realizado pensando em usar em diferentes dispositivos, por exemplo, assim se você realizar uma compra no celular e no computador, o carrinho estará sincronizado nos dois.

## Observer

O Observer foi implementado para fazer com que os agentes de logística sejam notificados quando um pedido foi confirmado ou cancelado pelo cliente, assim quando uma das operações acontecer, eles serão alertados e poderão dar prosseguimento aos processos do pedido.
