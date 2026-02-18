package com.leo.dominio.model;

import java.math.BigDecimal;

public class Produto {
    private String nome;
    private BigDecimal preco;

    public Produto(String nome, String preco){
        setNome(nome);
        setPreco(preco);
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("O nome não pode ser nulo.");
        }

        this.nome = nome;
    }

    public void setPreco(String preco) {
        BigDecimal valorPraComparacao = new BigDecimal(preco);
        BigDecimal valorZero = new BigDecimal(0);

        if (valorPraComparacao.compareTo(valorZero) == 0 || valorPraComparacao.compareTo(valorZero) < 0) {
            throw new IllegalArgumentException("O preço não pode ser menor ou igual a zero.");    
        }

        this.preco = valorPraComparacao;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
