package com.leo.dominio.model;

import java.math.BigDecimal; // fazer uma classe pra item pedido, assim posso ter mais de um produto igual sem lotar a lista

public class Produto {
    private String nome;
    private BigDecimal preco;

    public Produto(String nome, String preco){
        setNome(nome);
        setPreco(preco);
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou estar em branco.");
        }

        this.nome = nome;
    }

    public void setPreco(String preco) {
        preco = preco.replace(",", ".");
        BigDecimal valorPraComparacao = new BigDecimal(preco);

        if (valorPraComparacao.compareTo(BigDecimal.ZERO) == 0 || valorPraComparacao.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O preço tem que ser maior que zero.");    
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
