package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void assertivaAgrupada(){
        Pessoa pessoa = new Pessoa("Vinicius", "Cruz");

        assertAll("Asserções de pessoa",
                () -> assertEquals("Vinicius", pessoa.getNome()),
                () -> assertEquals("Cruz", pessoa.getSobrenome()));
    }

}