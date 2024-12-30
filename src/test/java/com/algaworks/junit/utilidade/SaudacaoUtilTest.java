package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

    @Test
    public void deveSaudarComBomDia(){
        String saudacao = SaudacaoUtil.saudar(9);
        assertEquals("Bom dia", saudacao, "Saudação incorreta!");
    }

    @Test
    public void deveSaudarComBomDia5h(){
        String saudacao = SaudacaoUtil.saudar(5);
        assertEquals("Bom dia", saudacao, "Saudação incorreta!");
    }

    @Test
    public void deveSaudarComBoaTarde(){
        String saudacao = SaudacaoUtil.saudar(14);
        assertEquals("Boa tarde", saudacao, "Saudação incorreta!");
    }

    @Test
    public void deveSaudarComBoaNoite(){
        String saudacao = SaudacaoUtil.saudar(20);
        assertEquals("Boa noite", saudacao, "Saudação incorreta!");
    }

    @Test
    public void deveSaudarComBoaNoite4h(){
        String saudacao = SaudacaoUtil.saudar(4);
        assertEquals("Boa noite", saudacao, "Saudação incorreta!");
    }

    @Test
    public void deveLancarException(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> SaudacaoUtil.saudar(-10));
        assertEquals("Hora inválida", illegalArgumentException.getMessage());
    }

    @Test
    public void naoDeveLancarException(){
        assertDoesNotThrow(() -> SaudacaoUtil.saudar(0));
    }

}