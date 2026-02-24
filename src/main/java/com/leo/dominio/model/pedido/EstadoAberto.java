package com.leo.dominio.model.pedido;

public class EstadoAberto implements EstadoDoPedido{
    private String estado = "ABERTO";

    public void pagar(Pedido pedido){ // classe pagamento
        // não
    }

    public void cancelar(Pedido pedido){
        // sim
    }

    public void enviar(Pedido pedido){
        // não
    }

    public String getEstado(){
        return this.estado;
    }
}
