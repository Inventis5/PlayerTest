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
        String nombre = "Steve";
        int vida = 15;
        int ataque = 20;
        player = new Player(nombre, vida, ataque);
    }

    @AfterEach
    void tearDown() {
        player = null;
    }

        @Test
    void curarSumaVida() {
        int beforeVida = player.getVida();
        player.curar(5);
        assertEquals(beforeVida + 5,player.getVida());


    }
    @Test
    void curarNoSuperaMaximo() {
        int beforeVida = player.getVida();
        player.curar(90);
        assertNotEquals(beforeVida + 90,player.getVida());
        assertTrue(player.getVida() <= 100);
    }

    @Test
    void curarUnMuertoNoFunciona() {
        player = new Player("Steve", 0, 10);
        player.curar(50);
        assertEquals(0,player.getVida());
    }

    @Test
    void curarUnMuertoNoFuncionaAtaque() {
        player.recibirDanyo(player.getVida());
        player.curar(50);
        assertEquals(0,player.getVida());
    }

    @Test
    void curarUnMuertoNoFuncionaAtaque() {
        player.recibirDanyo(player.getVida());
    }

    @AfterAll
    static void finalizarSuite() {
        System.out.println("Finalizan los tests");
    }
}