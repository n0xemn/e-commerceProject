package com.leo.dominio.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CPFTeste {
    
    @Test
    public void retornarStringSemPontosEtracos(){
        CPF cpf = new CPF("123");
        assertEquals("12345678901", cpf.reformatar("123.456.789-01"));
    }

    @Test
    public void cpfTem11DigitSeNmandaExcecao(){
        assertThrows(IllegalArgumentException.class, () -> new CPF("111.111.111-11"));
    }
}
