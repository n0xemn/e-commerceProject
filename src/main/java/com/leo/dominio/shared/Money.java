package com.leo.dominio.shared;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private final BigDecimal valor;
    private final String moeda; // TODO mudar pra uma classe de moeda depois, criar equals

    public Money(BigDecimal valor, String moeda){
        if (valor == null || valor.compareTo(BigDecimal.ZERO) == 0 || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor não pode ser nulo e deve ser maior que zero.");
        }
        if (moeda == null) {
            throw new IllegalArgumentException("O tipo de moeda não pode ser nulo.");
        }

        this.valor = valor.setScale(2, RoundingMode.HALF_EVEN);
        this.moeda = moeda;
    }

    // fiz dois pq vai que precisa, se não eu apago um dos dois
    public Money(String valor, String moeda){
        BigDecimal newDindin = new BigDecimal(valor);

        if (newDindin == null || newDindin.compareTo(BigDecimal.ZERO) == 0 || newDindin.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor não pode ser nulo e deve ser maior que zero.");
        }
        if (moeda == null) {
            throw new IllegalArgumentException("O tipo de moeda não pode ser nulo.");
        }

        this.valor = newDindin.setScale(2, RoundingMode.HALF_EVEN);
        this.moeda = moeda;
    }

    public void mesmaMoeda(Money dineiro){
        if (! this.moeda.equals(dineiro.moeda)) {
            throw new IllegalArgumentException("Não é a mesma moeda.");
        }
    }

    public Money somar(Money dinheiro){
        mesmaMoeda(dinheiro);

        return new Money(this.valor.add(dinheiro.valor), this.moeda);
    }

    public Money subtrair(Money dinheiro){
        mesmaMoeda(dinheiro);

        return new Money(this.valor.subtract(dinheiro.valor), this.moeda);
    }

    public Money multiplicar(BigDecimal valor){
        return new Money(this.valor.multiply(valor), this.moeda);
    }

    public Money dividir(BigDecimal valor){
        return new Money(this.valor.divide(valor), this.moeda);
    }

    public BigDecimal getValor(){
        return this.valor;
    }

    public String getMoeda(){ // TODO mudar retorno 
        return this.moeda;
    }
}
