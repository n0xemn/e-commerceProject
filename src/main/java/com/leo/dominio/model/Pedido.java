package com.leo.dominio.model;

import java.math.BigDecimal;
import java.util.List;

import com.leo.dominio.shared.Endereco;

public class Pedido {
    private String titular;
    private List<Produto> produtos;
    private BigDecimal valorTotal;
    private Endereco endereco; //TODO 2 casos de uso, um que o endereço é do cliente e o outro quando o endereço é novo
    private String estado;

    public Pedido(String titular, Endereco endereco){
        setTitular(titular);
        setEndereco(endereco);
        setEstado("Aberto");
        valorTotal = BigDecimal.ZERO;
    }

    public void setEndereco(Endereco endereco) {
        if (endereco == null) {
            throw new IllegalArgumentException("O endereço não pode ser nulo.");
        }

        this.endereco = endereco;
    }

    public void setTitular(String titular) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("O nome do titular não pode ser nulo ou estar em branco.");
        }
        
        this.titular = titular;
    }
    
    public void setEstado(String estado){
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("O estado não pode ser nulo ou estar em branco.");
        }
        this.estado = estado;
    }

    private void adicionarValor(BigDecimal novoValorSoma){
        this.valorTotal = valorTotal.add(novoValorSoma);
    }
    
    public void adicionarProduto(Produto novoProduto){ 
        if (novoProduto == null) {
            throw new IllegalArgumentException("O produto não pode ser null.");
        }

        produtos.add(novoProduto);
        adicionarValor(novoProduto.getPreco());
    }

    public void finalizarPedido(){ //TODO
        if (! (verificarValor(this.valorTotal))) {
            throw new IllegalArgumentException("O pedido deve ter um valor maior que zero.");
        }

        setEstado("Finalizado");
    }    

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public boolean verificarValor(BigDecimal valorTotal) {
        BigDecimal valorPraComparacao = valorTotal;

        if (valorPraComparacao.compareTo(BigDecimal.ZERO) == 0 || valorPraComparacao.compareTo(BigDecimal.ZERO) < 0) {
            return false;   
        }

        return true;
    }

    public void desconto(BigDecimal desconto){
        BigDecimal cem = new BigDecimal("100");

        this.valorTotal = valorTotal.subtract(valorTotal.multiply(desconto.divide(cem)));
    }
}