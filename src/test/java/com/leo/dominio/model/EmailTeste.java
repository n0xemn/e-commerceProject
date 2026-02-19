package com.leo.dominio.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTeste {
    
    @Test
    public void testarConstructorLancarExcecaoSeEmailInvalido(){
        assertThrows(IllegalArgumentException.class, () -> new Email("leo"));
    }
}
