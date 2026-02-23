package com.leo.dominio.model.pedido;

public class EstadoPago implements EstadoDoPedido{
    private String estado = "PAGO";
    
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
