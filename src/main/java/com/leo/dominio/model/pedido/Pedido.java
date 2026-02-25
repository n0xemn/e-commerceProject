package com.leo.dominio.model.pedido;

import java.math.BigDecimal;
import java.util.List;

import com.leo.dominio.model.Produto;
import com.leo.dominio.model.ProdutoPedido;
import com.leo.dominio.shared.Endereco;
import com.leo.dominio.shared.Money;

public class Pedido {
    private String titular;
    private List<ProdutoPedido> produtos;
    private Money valorTotal;
    private Endereco endereco; //TODO 2 casos de uso, um que o endereço é do cliente e o outro quando o endereço é novo, fazer um metodo remover produto da lista
    private EstadoDoPedido estado; // talvez mude
    // atbt pagamento

    public Pedido(String titular, Endereco endereco){
        setTitular(titular);
        setEndereco(endereco);
        this.estado = new EstadoAberto();
        this.valorTotal = new Money("0", definirMoeda(endereco));
    }

    private String definirMoeda(Endereco endereco){
        if (endereco.getPais().toUpperCase().equals("BRASIL")) {
            return "REAL";
        }

        return "nium";
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

    private void somarNoValorTotal(Money valorCalcular){ 
        this.valorTotal = valorTotal.somar(valorCalcular);
    }

    private void subtrairNoValorTotal(Money valorCalcular){
        this.valorTotal = valorTotal.subtrair(valorCalcular);
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

        somarNoValorTotal(new Money(novoProduto.getPreco().getValor().multiply(new BigDecimal(quantidadePedido)), novoProduto.getPreco().getMoeda()));
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
        if (! (verificarValorTotal())) {
            throw new IllegalArgumentException("O pedido deve ter um valor maior que zero.");
        }

        this.estado = new EstadoFechado();
    }    

    public Money getValorTotal() {
        return valorTotal;
    }

    public boolean verificarValorTotal() {
        if (this.valorTotal.getValor().compareTo(BigDecimal.ZERO) == 0 || this.valorTotal.getValor().compareTo(BigDecimal.ZERO) < 0) {
            return false;   
        }

        return true;
    }

    public void desconto(BigDecimal desconto){
        subtrairNoValorTotal(this.valorTotal.multiplicar(desconto.divide(new BigDecimal("100"))));
    }

    public String getEstado(){
        return this.estado.getEstado();
    }

    // só muda estado?
    public void pagar(){ // caso de uso pagamento vai cuidar do metodo de pagamento, vai mudar o estado do pedido
        this.estado.pagar(this);
    }
}