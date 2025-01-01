package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes no utilitário de saudação")
class SaudacaoUtilTest {

    @Test
    @DisplayName("Deve saudar com bom dia")
    public void deveSaudarComBomDia(){
        String saudacao = SaudacaoUtil.saudar(9);
        assertEquals("Bom dia", saudacao, "Saudação incorreta!");
    }

    @Test
    @DisplayName("Deve saudar com bom dia às 5 horas")
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

    @Test //Padrão AAA
    public void deveLancarException(){
        int horaInvalida = -10;
        Executable chamadaDeMetodoInvalida = () -> SaudacaoUtil.saudar(horaInvalida);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, chamadaDeMetodoInvalida);
        assertEquals("Hora inválida", illegalArgumentException.getMessage());
    }

    @Test
    public void naoDeveLancarException(){
        int horaValida = 0;
        Executable chamadaDeMetodoValida = () -> SaudacaoUtil.saudar(horaValida);
        assertDoesNotThrow(() -> chamadaDeMetodoValida);
    }

}