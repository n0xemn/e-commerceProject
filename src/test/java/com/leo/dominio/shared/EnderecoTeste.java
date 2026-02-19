package com.leo.dominio.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnderecoTeste {
    
    @Test
    public void testarConstructorSeEnderecoInvalidoLancarExcecao(){
        assertThrows(IllegalArgumentException.class, () -> new Endereco(null, null, null, null, -1));
    }
}
