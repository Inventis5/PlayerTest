package com.MateuGiner.tema4gradle;

import java.util.Objects;

public class Player {
    private final String nombre;
    private int vida;
    private final int ataque;

    public Player(String nombre, int vida, int ataque) {
        if (vida < 0 || vida > 100) {
            throw new IllegalArgumentException();
        }
        if (ataque <= 0) {
            throw new IllegalArgumentException();
        }
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }


    // Recibe daño teniendo en cuenta la defensa
    public void recibirDanyo(int cantidad) {
        vida -= cantidad;
        if (vida < 0) {
            vida = 0; // Ha muerto
        }
    }

    // Cura vida (máximo 100)
    public void curar(int cantidad) {
        if (vida == 0 || cantidad < 0) { // Tratamos los casos problemáticos tan pronto como sea posible
            return;
        }
        vida += cantidad;
        if (vida > 100) {
            vida = 100;
        }
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Player player)) return false;

        return vida == player.vida && ataque == player.ataque &&  Objects.equals(nombre, player.nombre);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(nombre);
        result = 31 * result + vida;
        result = 31 * result + ataque;
        return result;
    }

    @Override
    public String toString() {
        return "Player{" +
                "nombre='" + nombre + '\'' +
                ", vida=" + vida +
                ", ataque=" + ataque +
                '}';
    }
}
