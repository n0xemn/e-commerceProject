package com.leo.dominio.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CPFTeste {
    
    @Test
    public void retornarStringSemPontosEtracos(){
        CPF cpf = new CPF("16231387607"); // use seu cpf pra esse teste dar certo
        assertEquals("12345678901", cpf.reformatar("123.456.789-01"));
    }

    @Test
    public void cpfTem11DigitSeNmandaFalse(){
        CPF cpf = new CPF("16231387607"); // use seu cpf pra esse teste dar certo
        assertTrue(cpf.testarTamanho("12312312312"));
    }

    @Test
    public void cpfTemQueSerValidoSeNmandaFalse(){
        CPF cpf = new CPF("16231387607"); // use seu cpf pra esse teste dar certo
        assertFalse(cpf.validarCPF("12312312312"));
    }
}
