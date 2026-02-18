package com.leo.dominio.model;

public class CPF {
    private final String valor;

    public CPF(String cpf){
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("O cpf não pode ser nulo ou vazi.");
        }

        this.valor = cpf;
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

    // TODO hashcode

    public String getValor() {
        return valor;
    }
}
