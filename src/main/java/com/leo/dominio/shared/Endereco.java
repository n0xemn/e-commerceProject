package com.leo.dominio.shared;

import java.util.Objects;

public class Endereco { //TODO acho que tem coisa pra fazer, ou não
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private int numero;

    public Endereco(String pais, String estado, String cidade, String bairro, int numero){
        setPais(pais);
        setEstado(estado);
        setCidade(cidade);
        setBairro(bairro);
        setNumero(numero);
    }

    public void setBairro(String bairro) {
        if (bairro == null || bairro.isBlank()) {
            throw new IllegalArgumentException("O bairro não pode ser nulo ou estar vazio.");
        }

        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        if (cidade == null || cidade.isBlank()) {
            throw new IllegalArgumentException("O cidade não pode ser nulo ou estar vazio.");
        }

        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("O estado não pode ser nulo ou estar vazio.");
        }

        this.estado = estado;
    }

    public void setNumero(int numero) {
        if ( numero < 0) {
            throw new IllegalArgumentException("O numero não pode ser menor que zero.");
        }

        this.numero = numero;
    }

    public void setPais(String pais) {
        if (pais == null || pais.isBlank()) {
            throw new IllegalArgumentException("O pais não pode ser nulo ou estar vazio.");
        }
        
        this.pais = pais;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public int getNumero() {
        return numero;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public boolean equals(Object e){
        if(this == e){
            return true;
        }

        if (e == null || this.getClass() != e.getClass()) {
            return false;
        }

        Endereco comparar = (Endereco) e;
        return this.getPais().equals(comparar.getPais()) && this.getEstado().equals(comparar.getEstado()) && this.getCidade().equals(comparar.getCidade()) && this.getBairro().equals(comparar.getBairro()) && this.getNumero() == comparar.getNumero();
    }

    @Override
    public int hashCode() {
        return Objects.hash(pais, estado, cidade, bairro, numero);
    }
}
