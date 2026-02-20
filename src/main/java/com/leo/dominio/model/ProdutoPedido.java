package com.leo.dominio.model;

import java.math.BigDecimal;

public class ProdutoPedido {
    private Produto produto;
    private int quantidadePedido;
    private BigDecimal precoUnitario;

    public ProdutoPedido(Produto produto, int quantidadePedido){
        setProduto(produto);
        adicionarQuantidade(quantidadePedido);
        precoUnitario = produto.getPreco(); 
    }

    public void setProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }

        this.produto = produto;
    }

    public void adicionarQuantidade(int quantidadePedido) {
        if (quantidadePedido <= 0) {
            throw new IllegalArgumentException("A quantidade tem que ser maior que zero.");
        }

        this.quantidadePedido += quantidadePedido;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidadePedido() {
        return quantidadePedido;
    }

    public Produto getProduto() {
        return produto;
    }
}
