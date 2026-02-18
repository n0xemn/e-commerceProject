package com.leo.dominio.repository;

import java.util.ArrayList;
import java.util.List;

import com.leo.dominio.model.Cliente;

// TODO fazer um remover

public class ClientesRepository {
    private List<Cliente> listaClientes = new ArrayList<>();
    
    public ClientesRepository(){
    }

    public void adicionarCliente(Cliente novoCliente){
        if (novoCliente == null) {
            throw new IllegalArgumentException("O objeto cliente passado não pode ser null.");
        }

        listaClientes.add(novoCliente);
    }

    public Cliente acharPorPosicao(int posicao){
        if (posicao < 0 || posicao >= this.listaClientes.size()) {
            throw new IllegalArgumentException("A posição não pode ser negativa ou ser maior ou igual ao número de clientes cadastrados.");
        }

        return listaClientes.get(posicao);
    }

    /*public List<Cliente> getListaClientes(){
        return this.listaClientes;
    }*/

    public int getNumeroDeClientes() {
        return listaClientes.size();
    }

    /*public void remover(Cliente cliente){
        this.
        if (condition) {
            
        }
    }*/
}
