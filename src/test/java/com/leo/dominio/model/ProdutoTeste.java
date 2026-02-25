package com.leo.dominio.model;

import org.junit.jupiter.api.Test;

import com.leo.dominio.shared.Money;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTeste {
    
    @Test
    public void nomeNaoPodeSerNullLancarExcecao(){
        Money moni = new Money("2.0", "REAL");
        assertThrows(IllegalArgumentException.class, () -> new Produto(null, moni));
    }

    @Test
    public void produtoIgualDaTrue(){
        Money moni = new Money("2.0", "REAL"); // não tem equals no Money ainda
        Money monie = new Money("2.0", "REAL");
        Produto prod1 = new Produto("salada", moni);
        Produto prod2 = new Produto("salada", monie);

        assertTrue(prod1.equals(prod2));
    }
}
