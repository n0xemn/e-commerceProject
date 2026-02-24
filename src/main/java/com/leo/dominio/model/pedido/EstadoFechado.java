package com.leo.dominio.model.pedido;

public class EstadoFechado implements EstadoDoPedido{
    private String estado = "FECHADO";

    public void pagar(Pedido pedido){ // agente externo
        // sim
    }

    public void cancelar(Pedido pedido){
        // sim
    }

    public void enviar(Pedido pedido){
        // sim
    }

    public String getEstado(){
        return this.estado;
    }
}
