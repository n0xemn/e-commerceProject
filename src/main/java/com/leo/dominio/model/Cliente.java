package com.leo.dominio.model;

public class Cliente {
    private final CPF cpf; //TODO classe pra email e endereço, criar tipo de cliente, vip e normal
    private Email email;
    private int idade;
    private String nome;
    private String endereco;

    public Cliente(String nome, int idade, String cpf, String email, String endereco) {
        this.cpf = new CPF(cpf); 
        setIdade(idade);
        setNome(nome);
        setEmail(email);
        setEndereco(endereco);
    }

    public void setEndereco(String endereco) {
        if (endereco == null) {
            throw new IllegalArgumentException("O endereço não pode ser nulo.");
        }

        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = new Email(email);
    }

    public void setIdade(int idade) {
        if (idade <= 0) {
            throw new IllegalArgumentException("A idade não pode ser menor ou igual a zero.");
        }

        this.idade = idade;
    }

    public void setNome(String nome) { 
        if (nome == null) {
            throw new IllegalArgumentException("O nome não pode ser nulo.");
        }

        this.nome = nome;
    }

    public String getEmail() {
        return email.getValor();
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return this.cpf.getValor();
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object e){
        if(this == e){
            return true;
        }

        if (e == null || this.getClass() != e.getClass()) {
            return false;
        }

        Cliente comparar = (Cliente) e;
        return this.getCpf().equals(comparar.getCpf()) && this.getEmail().equals(comparar.getEmail()) && this.nome.equals(comparar.getNome()) && this.idade == comparar.getIdade();
    }
}
