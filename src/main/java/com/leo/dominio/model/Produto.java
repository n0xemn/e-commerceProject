package com.leo.dominio.model;

import java.util.Objects;

import com.leo.dominio.shared.Money;

public class Produto {
    private String nome;
    private Money preco;

    public Produto(String nome, Money preco){
        setNome(nome);
        this.preco = preco;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou estar em branco.");
        }

        this.nome = nome;
    }

    // preco = preco.replace(",", "."); mantive isso pra não esquecer a forma que faz

    public String getNome() {
        return nome;
    }

    public Money getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object e){
        if(this == e){
            return true;
        }

        if (e == null || this.getClass() != e.getClass()) {
            return false;
        }

        Produto comparar = (Produto) e;
        return this.nome.equals(comparar.getNome()) && this.preco.equals(comparar.getPreco());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, preco);
    }
}
