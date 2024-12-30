package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    @Test
    void deveLancarExcecaoAoPassarNullParaConstrutor(){
         assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(null));
    }

    @Test
    void deveAdicionarSaldoAoCriarContaComSaldoPositivo(){
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(100));
        assertEquals(contaBancaria.saldo(), BigDecimal.valueOf(100));
    }

    @Test
    void deveAdicionarSaldoAoCriarContaComSaldoNegativo(){
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(-100));
        assertEquals(contaBancaria.saldo(), BigDecimal.valueOf(-100));
    }

    @Test
    void deveAdicionarSaldoAoCriarContaComSaldoZero(){
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(0));
        assertEquals(contaBancaria.saldo(), BigDecimal.valueOf(0));
    }

    @Test
    void deveSacarAoForncerValorValido(){
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(100));
        contaBancaria.saque(BigDecimal.valueOf(50));
        assertEquals(contaBancaria.saldo(), BigDecimal.valueOf(100).subtract(contaBancaria.saldo()));
    }

    @Test
    void deveLancarExcecaoAoPassarZeroParaSacar(){
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(100));
        assertThrows(IllegalArgumentException.class, () -> contaBancaria.saque(ZERO));
    }

    @Test
    void deveLancarExcecaoAoPassarNullParaSacar(){
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(100));
        assertThrows(IllegalArgumentException.class, () -> contaBancaria.saque(null));
    }

    @Test
    void deveLancarExcecaoAoPassarValorNegativoParaSacar(){
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(100));
        assertThrows(IllegalArgumentException.class, () -> contaBancaria.saque(BigDecimal.valueOf(-10)));
    }

    @Test
    void deveLancarExcecaoQuandoSaldoInsuficiente(){
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(50));
        assertThrows(RuntimeException.class, () -> contaBancaria.saque(BigDecimal.valueOf(100)));
    }

    @Test
    void deveDepositarAoForncerValorValido(){
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(0));
        contaBancaria.deposito(BigDecimal.valueOf(200));
        assertEquals(contaBancaria.saldo(), BigDecimal.valueOf(200));
    }

    @Test
    void deveLancarExcecaoAoPassarNullParaDepositar(){
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(100));
        assertThrows(IllegalArgumentException.class, () -> contaBancaria.deposito(null));
    }

    @Test
    void deveLancarExcecaoAoPassarZeroParaDepositar(){
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(100));
        assertThrows(IllegalArgumentException.class, () -> contaBancaria.deposito(null));
    }

    @Test
    void deveLancarExcecaoAoPassarNegativoParaDepositar(){
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(100));
        assertThrows(IllegalArgumentException.class, () -> contaBancaria.deposito(BigDecimal.valueOf(-30)));
    }

    @Test
    void deveRetornarSaldo(){
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.valueOf(100));
        assertNotNull(contaBancaria.saldo());
    }
}