package com.leo.dominio.model.pedido;

public class EstadoPago implements EstadoDoPedido{
    private String estado = "PAGO";
    
    public void pagar(Pedido pedido){
        //não acontece
    }

    public void cancelar(Pedido pedido){
        // não acoontece
    }

    public void enviar(Pedido pedido){
        // acontece
    }

    public String getEstado(){
        return this.estado;
    }
}
