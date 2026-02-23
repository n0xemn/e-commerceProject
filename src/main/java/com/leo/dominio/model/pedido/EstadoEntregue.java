package com.leo.dominio.model.pedido;

public class EstadoEntregue implements EstadoDoPedido{
    private String estado = "ENTREGUE";

    public void pagar(Pedido pedido){

    }

    public void cancelar(Pedido pedido){

    }

    public void enviar(Pedido pedido){

    }

    public String getEstado(){
        return this.estado;
    }
}
