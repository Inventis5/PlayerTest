package com.MateuGiner.tema4gradle;

import com.MateuGiner.tema4gradle.Config.Config;
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
        player = new Player(Config.PLAYER_NOMBRE, Config.PLAYER_VIDA, Config.PLAYER_ATAQUE);
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

    void constructorInstanciaInstaladaCorrectamente() {
    assertEquals(Config.PLAYER_NOMBRE, player.getNombre());
    assertEquals(Config.PLAYER_VIDA, player.getVida());
    assertEquals(Config.PLAYER_ATAQUE, player.getAtaque());
    }

    @Test
    void VidaNegativa() {
    assertThrows(IllegalArgumentException.class, () -> {player = new  Player("Steve", -10, 10);});

    }

    @Test
    void AtaqueNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {player = new  Player("Steve", 10, -10);});
    }

    @Test
    void constructorNoSuperaVidaMaximo() {
        assertThrows(IllegalArgumentException.class, () -> {player = new  Player("Steve", 105, 10);});
    }

    @Test
    void recibirDanyoNoPermiteVidaNegativa() {
        player.recibirDanyo(player.getVida() + 10);
        assertEquals(0, player.getVida());
    }

    @Test
    void recibirDanyo() {
        int danyo = 10;
        player.recibirDanyo(danyo);
        assertEquals(Config.PLAYER_VIDA - danyo, player.getVida());
    }

    @Test
    void recibirDanyoNoPermiteCantidadNegativa() {
        int danyo = -10;
        player.recibirDanyo(danyo);
        assertThrows(Exception.class, () -> {player.recibirDanyo(danyo);});

    }

    @AfterAll
    static void finalizarSuite() {
        System.out.println("Finalizan los tests");
    }
}