package com.leo.dominio.model;

import java.util.Objects;

public class Email {
    private String valor;

    public Email(String email){
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("O email não pode ser nulo ou estar vazio.");
        }

        if (! email.matches("^[A-Za-z0-9+._-]+@[A-Za-z0-9+._-]+$")) { // regex: ^ marca o começa da string, $ marca o fim da string, [] tudo que pode ter na string, + depois de [] significa que não pode ser vazio, @ literal o caracter @.
            throw new IllegalArgumentException("E-mail inválido.");
        }

        this.valor = email;
    }
    
    @Override
    public boolean equals(Object e){
        if(this == e){
            return true;
        }
        
        if (e == null || this.getClass() != e.getClass()) {
            return false;
        }
        
        Email comparar = (Email) e;
        return this.valor.equals(comparar.getValor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
    
    public String getValor() {
        return valor;
    }
}
