package com.leo.dominio.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoPedidoTeste {
    
    @Test
    public void parametrosInvlidosConstructorLancaExcecoes(){
        Produto prod1 = new Produto("Batata", "2,5");

        assertThrows(IllegalArgumentException.class, () -> new ProdutoPedido(prod1, 0));
    }
}
