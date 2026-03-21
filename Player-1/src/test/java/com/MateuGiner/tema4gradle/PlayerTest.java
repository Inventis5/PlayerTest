package com.MateuGiner.tema4gradle;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;
    @BeforeAll
    static void iniciarSuite() {
        System.out.println("Comienzan los tests");
    }

    @BeforeEach
    void setup() {
        final String nombre = "Steve";
        final int vida = 10;
        final int ataque = 20;
        player = new Player(nombre, vida, ataque);
    }

    @AfterEach
    void tearDown() {
        player = null;
    }

        @Test
    void curarSumaVida() {
        player.curar(5);
        assertEquals(10,player.getVida());


    }
    @Test
    void curarNoSuperaMaximo() {
        player.curar(15);
        assertEquals(100,player.getVida());
        assertTrue(player.getVida() < 105);
    }

    @Test
    void curarUnMuertoNoFunciona() {
        player.curar(50);
        assertEquals(0,player.getVida());
    }

    @Test
    void curarUnMuertoNoFuncionaAtaque() {
        player.recibirDanyo(10);
        player.curar(50);
        assertEquals(0,player.getVida());
    }

    @AfterAll
    static void finalizarSuite() {
        System.out.println("Finalizan los tests");
    }
}