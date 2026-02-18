package com.leo.aplicacao.service;

import com.leo.dominio.model.Cliente;
import com.leo.dominio.repository.ClientesRepository;

public class ClienteService {

    private final ClientesRepository clienteRepositorio;

    public ClienteService(ClientesRepository clienteRepositorio){
        this.clienteRepositorio = clienteRepositorio;
    }
    
    public void cadastrarCliente(String nome, int idade, String cpf, String email, String endereco){
        try {
            Cliente cliente = new Cliente(nome, idade, cpf, email, endereco);
            guardarEmRepository(cliente);
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void guardarEmRepository(Cliente cliente){
        clienteRepositorio.adicionarCliente(cliente);
    }

    /*public List<Cliente> buscarClientes(){
        return clienteRepositorio.getListaClientes();
    }*/

    public Cliente buscarClientesPorPosicao(int posicao) throws IllegalArgumentException{
        return clienteRepositorio.acharPorPosicao(posicao);
    }

    public int quantidadeClientes(){
        return clienteRepositorio.getNumeroDeClientes();
    }

    public void cadastrarCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarCliente'");
    }
}
