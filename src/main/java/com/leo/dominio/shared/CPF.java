package com.leo.dominio.shared;

import java.util.Objects;

// pra validação de cpf
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public final class CPF {
    private final String valor;

    public CPF(String cpf){
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("O cpf não pode ser nulo ou vazio.");
        }

        cpf = reformatar(cpf);

        if (! testarTamanho(cpf)) {
            throw new IllegalArgumentException("Tamanho incorreto de cpf, deve ter 11 números.");
        }

        if (! validarCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }

        this.valor = cpf;
    }

    public boolean testarTamanho(String cpf){
        if (cpf.length() != 11) {
            return false;
        }

        return true;
    }

    public boolean validarCPF(String cpf){ 
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
            return true;
        } catch (InvalidStateException e) {
            return false;
        }
    }

    @Override
    public boolean equals(Object e){
        if(this == e){
            return true;
        }

        if (e == null || this.getClass() != e.getClass()) {
            return false;
        }

        CPF comparar = (CPF) e;
        return this.valor.equals(comparar.getValor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    public String reformatar(String cpf){
        return cpf.replaceAll("\\D", ""); // \D todo caracter que não estaja entre 0-9. \d é todo caracter que esteja entre 0-9
    }
    
    public String getValor() {
        return valor;
    }
}
