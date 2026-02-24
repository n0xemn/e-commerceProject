package com.leo.dominio.model.pedido;

public class EstadoEntregue implements EstadoDoPedido{
    private String estado = "ENTREGUE";

    public void pagar(Pedido pedido){
        // não
    }

    public void cancelar(Pedido pedido){
        // não
    }

    public void enviar(Pedido pedido){
        // não
    }

    public String getEstado(){
        return this.estado;
    }
}
