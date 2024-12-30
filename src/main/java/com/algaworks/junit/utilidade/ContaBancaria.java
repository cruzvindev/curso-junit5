package com.algaworks.junit.utilidade;

import java.math.BigDecimal;
import java.util.Objects;

import static java.math.BigDecimal.ZERO;

public class ContaBancaria {
    private BigDecimal saldo;

    public ContaBancaria(BigDecimal saldo) {
        if(Objects.isNull(saldo)){
            throw new IllegalArgumentException("O saldo não pode ser nulo");
        }
        this.saldo = saldo;
    }

    public void saque(BigDecimal valor) {
        if(Objects.isNull(valor) || valor.equals(ZERO) || valor.doubleValue() < 0){
            throw new IllegalArgumentException("O valor fornecido para saque é inválido");
        }

        if(this.saldo.doubleValue() < valor.doubleValue()){
            throw new RuntimeException("Saldo insuficiente");
        }
        this.saldo = this.saldo.subtract(valor);
    }

    public void deposito(BigDecimal valor) {
        if(Objects.isNull(valor) || valor.equals(ZERO) || valor.doubleValue() < 0){
            throw new IllegalArgumentException("O valor fornecido para saque é inválido");
        }
        this.saldo = valor;
    }
    public BigDecimal saldo() {
        return this.saldo;
    }
}
