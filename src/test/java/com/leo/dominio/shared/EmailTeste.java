package com.leo.dominio.shared;

import org.junit.jupiter.api.Test;

import com.leo.dominio.shared.Email;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTeste {
    
    @Test
    public void testarConstructorLancarExcecaoSeEmailInvalido(){
        assertThrows(IllegalArgumentException.class, () -> new Email("leo"));
    }
}
