package com.leo.dominio.model;

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
}
