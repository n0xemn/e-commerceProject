package com.leo.dominio.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTeste { // cada teste tem um metodo
    
    @Test //falar pro sistema que é um teste
    public void naoPodeIdadeNegativaTemQueLancarExcecao(){
        assertThrows(IllegalArgumentException.class, () -> new Cliente("Leo", -21, "123", "emailqualquer", "cepqualquer")); // averiguar se o metodo passado lança a exceçao passada
    }

    @Test
    public void verSeClientesSaoIguais(){
        Cliente cliente1 = new Cliente("leo", 2, "12345678901", "emailqualquer", "cepqualquer");
        Cliente cliente2 = new Cliente("leo", 2, "12345678901", "emailqualquer", "cepqualquer");

        assertEquals(cliente1, cliente2);
    }

    @Test
    public void naoPodeNomeNullLancarExcecao(){
        assertThrows(IllegalArgumentException.class, () -> new Cliente(null, 21, "123", "emailqualquer", "cepqualquer"));
    }

    @Test
    public void naoPodeEmailNullLancarExcecao(){
        assertThrows(IllegalArgumentException.class, () -> new Cliente("leo", 21, "123", null, "cepqualquer"));
    }

    @Test
    public void naoPodeEnderecoNullLancarExcecao(){
        assertThrows(IllegalArgumentException.class, () -> new Cliente("leo", 21, "123", "emailqualquer", null));
    }
    // assertFalse(metodo boleano que da false);
}
