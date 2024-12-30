package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

class SimuladorEsperaTest {

    @Test
    @Disabled("Não é mais aplicável")
    public void deveEsperarENaoDarTimeout(){
        //assertTimeout(ofSeconds(1), () -> SimuladorEspera.esperar(ofSeconds(10)));
        assertTimeoutPreemptively(ofSeconds(1), () -> SimuladorEspera.esperar(ofSeconds(10)));
    }

}