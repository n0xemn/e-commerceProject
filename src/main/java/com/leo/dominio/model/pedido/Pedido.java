package com.leo.dominio.model.pedido;

import java.math.BigDecimal;
import java.util.List;

import com.leo.dominio.model.Produto;
import com.leo.dominio.model.ProdutoPedido;
import com.leo.dominio.shared.Endereco;

public class Pedido {
    private String titular;
    private List<ProdutoPedido> produtos;
    private BigDecimal valorTotal;
    private Endereco endereco; //TODO 2 casos de uso, um que o endereço é do cliente e o outro quando o endereço é novo, fazer um metodo remover produto da lista
    private EstadoDoPedido estado; // talvez mude

    public Pedido(String titular, Endereco endereco){
        setTitular(titular);
        setEndereco(endereco);
        estado = new EstadoAberto();
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

    private void atualizarValorTotal(BigDecimal valorCalcular){ 
        this.valorTotal = valorTotal.add(valorCalcular);
    }
    
    //TODO fazer os testes
    public void adicionarProduto(Produto novoProduto, int quantidadePedido){ 
        if (novoProduto == null) {
            throw new IllegalArgumentException("O produto não pode ser null.");
        }

        if (quantidadePedido <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }

        if (verSeJaEstaNaLista(novoProduto)) {
            this.produtos.get(acharIndiceDeProdutoIgual(novoProduto)).adicionarQuantidade(quantidadePedido);
        } else {
            produtos.add(new ProdutoPedido(novoProduto, quantidadePedido));
        }

        BigDecimal novoPreco = novoProduto.getPreco().multiply(new BigDecimal(quantidadePedido)); 
        atualizarValorTotal(novoPreco);
    }

    private int acharIndiceDeProdutoIgual(Produto produto){
        int i;
        for(i = 0; i < this.produtos.size(); i++){
            if (produto.equals(produtos.get(i).getProduto())) {
                break;
            }
        }
        
        return i;
    }

    private boolean verSeJaEstaNaLista(Produto produto){
        for(int i = 0; i < this.produtos.size(); i++){
            if (produto.equals(produtos.get(i).getProduto())) {
                return true;
            }
        }

        return false;
    }

    public void finalizarPedido(){
        if (! (verificarValor(this.valorTotal))) {
            throw new IllegalArgumentException("O pedido deve ter um valor maior que zero.");
        }

        this.estado = new EstadoFechado();
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
        atualizarValorTotal((this.valorTotal.multiply(desconto.divide(new BigDecimal("100")))).multiply(new BigDecimal("-1")));
    }

    public String getEstado(){
        return this.estado.getEstado();
    }

    public void pagar(){
        
    }
}