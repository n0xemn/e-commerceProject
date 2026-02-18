package com.leo.dominio.model;

import java.math.BigDecimal;
import java.util.List;

// TODO não está finalizado, falta coisa ainda

public class Pedido {
    private String titular;
    private List<Produto> produtos;
    private BigDecimal valorTotal; // usado só quando o pedido é fechado
    private String endereco; //TODO fazer uma classe pra endereço, 2 casos de uso, um que o endereço é do cliente e o outro quando o endereço é novo
    private String estado;

    public Pedido(String titular, String endereco){
        setTitular(titular);
        setEndereco(endereco);
        setEstado("Aberto");
        valorTotal = BigDecimal.ZERO;
    }

    public void setEndereco(String endereco) {
        if (endereco == null) {
            throw new IllegalArgumentException("O endereço não pode ser nulo.");
        }

        this.endereco = endereco;
    }

    public void setTitular(String titular) {
        if (titular == null) {
            throw new IllegalArgumentException("O nome do titular não pode ser nulo.");
        }
        
        this.titular = titular;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }

    private void setValorTotal(BigDecimal novoValorSoma){
        this.valorTotal = valorTotal.add(novoValorSoma);
    }
    
    public void adicionarProduto(Produto novoProduto){ 
        if (novoProduto == null) {
            throw new IllegalArgumentException("O produto não pode ser null."); // nem sei se da pra passar null nessas ocasioes
        }

        produtos.add(novoProduto);
        setValorTotal(novoProduto.getPreco());
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
        BigDecimal valorZero = new BigDecimal(0);

        if (valorPraComparacao.compareTo(valorZero) == 0 || valorPraComparacao.compareTo(valorZero) < 0) {
            return false;   
        }

        return true;
    }

    public void desconto(BigDecimal desconto){
        BigDecimal cem = new BigDecimal("100");

        this.valorTotal = valorTotal.subtract(valorTotal.multiply(desconto.divide(cem)));
    }
}