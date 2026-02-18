package com.leo.dominio.model;

public final class CPF {
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

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    public String getValor() {
        return valor;
    }

    public String reformatar(String cpf){
        return cpf.replaceAll("\\D", "");
    }
}
