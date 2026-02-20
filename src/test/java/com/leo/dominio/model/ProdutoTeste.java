package com.leo.dominio.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTeste {
    
    @Test
    public void nomeNaoPodeSerNullLancarExcecao(){
        assertThrows(IllegalArgumentException.class, () -> new Produto(null, "2.55"));
    }

    @Test
    public void precoNaoPodeSerZeroNegatiLancarExce(){
        assertThrows(IllegalArgumentException.class, () -> new Produto("comida", "0"));
    }
}
