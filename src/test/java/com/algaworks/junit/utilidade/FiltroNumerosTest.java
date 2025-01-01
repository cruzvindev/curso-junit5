package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FiltroNumerosTest {

//    @Test
//    public void deve_Retornar_Numeros_Pares(){
//        List<Integer> numeros = Arrays.asList(1,2,3,4);
//        List<Integer> numerosParesEsperados = Arrays.asList(2,4);
//        List<Integer> resultadoFiltro = FiltroNumeros.numerosPares(numeros);
//        //Assertions.assertArrayEquals(numerosParesEsperados.toArray(new Object[]{}), resultadoFiltro.toArray(new Object[]{}));
//        assertIterableEquals(numerosParesEsperados, resultadoFiltro);
//    }

    //Given When Then
    @Test
    public void Dado_uma_lista_de_numeros_Quando_filtrar_por_impares_Então_deve_retornar_apenas_numeros_impares(){
        List<Integer> numeros = Arrays.asList(1,2,3,4);
        List<Integer> numerosImparesEsperados = Arrays.asList(1,3);
        List<Integer> resultadoFiltro = FiltroNumeros.numerosImpares(numeros);
        //Assertions.assertArrayEquals(numerosParesEsperados.toArray(new Object[]{}), resultadoFiltro.toArray(new Object[]{}));
        assertIterableEquals(numerosImparesEsperados, resultadoFiltro);
    }

}