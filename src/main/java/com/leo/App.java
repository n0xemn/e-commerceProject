package com.leo;

import com.leo.aplicacao.controler.ClienteControler;
import com.leo.aplicacao.controler.MenuPrincipalControler;
import com.leo.aplicacao.service.ClienteService;
import com.leo.dominio.repository.ClientesRepository;

public class App {
    public static void main(String[] args) {
        ClientesRepository clientesRepository = new ClientesRepository();

        ClienteService clienteService = new ClienteService(clientesRepository);

        ClienteControler clienteControler = new ClienteControler(clienteService);

        MenuPrincipalControler menuPrincipalControler = new MenuPrincipalControler(clienteControler);
        
        menuPrincipalControler.start();
    }
}
