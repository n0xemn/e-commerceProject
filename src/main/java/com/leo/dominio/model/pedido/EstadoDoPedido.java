package com.leo.dominio.model.pedido;

public interface EstadoDoPedido {
    // o pedido vai fechar quando o cliente escolher o tipo de pagamento e a mercadoria só vai ser enviada se o pedido estiver fechado
    // se for pix ou cartão ele paga antes do envio, se for dinheiro, ele envia e é dado como pago po outra coisa
    void pagar(Pedido pedido);
    void cancelar(Pedido pedido);
    void enviar(Pedido pedido); // talvez
    String getEstado();

    // aberto, fechado, pago, entregue
}
