package com.leo.aplicacao.controler;

import com.leo.aplicacao.service.ClienteService;
import com.leo.dominio.model.Cliente;

public class ClienteControler {
    ClienteService clienteService;

    public ClienteControler(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    public void start(){ // interação com o usuario e os caralho
        System.out.println("Cadastro de clientes:\n\n");
    }

    public void exibirClientes(){
        for (int i = 0; i < clienteService.quantidadeClientes(); i++) {
            Cliente cliente = clienteService.buscarClientesPorPosicao(i);
            System.out.println(); // aqui eu printo as info do cliente
        }
    }
}
