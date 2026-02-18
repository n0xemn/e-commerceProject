package com.leo.dominio.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CPFTeste {
    
    @Test
    public void retornarStringSemPontosEtracos(){
        CPF cpf = new CPF("123");
        assertEquals("12345678901", cpf.reformatar("123.456.789-01"));
    }
}
