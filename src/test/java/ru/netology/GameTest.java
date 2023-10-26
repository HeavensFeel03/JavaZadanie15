package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    Game gam = new Game();
    Player item1 = new Player(3, "Kolya", 7);
    Player item2 = new Player(4, "Petya", 8);
    Player item3 = new Player(6, "Vlad", 9);
    Player item4 = new Player(9, "Arkadii", 4);
    Player item5 = new Player(11, "Slava", 8);
    Player item6 = new Player(33, "Sasha", 10);
    Player item7 = new Player(90, "Evgenii", 20);

    @BeforeEach
    public void setup() {
        gam.add(item1);
        gam.add(item2);
        gam.add(item3);
        gam.add(item4);
        gam.add(item5);
    }


    @Test
    public void shouldAllPlayers() {
        Player[] expected = {item1, item2, item3, item4, item5};
        Player[] actual = gam.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRoundPlayers2() {
        int expected = 2;
        int actual = gam.round("Kolya", "Petya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundPlayers1() {
        int expected = 1;
        int actual = gam.round("Vlad", "Arkadii");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundPlayers0() {
        int expected = 0;
        int actual = gam.round("Slava", "Petya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void noShouldRoundPlayers2() {
        gam.add(item7);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            gam.round("Kolya", "Evgenii");
        });
    }

    @Test
    public void noShouldRoundPlayers1() {
        gam.add(item6);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            gam.round("Sasha", "Kolya");
        });
    }

    @Test
    public void ShouldRoundNotFoundPlayers1() {
        gam.add(item6);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            gam.round("Sveta", "Kolya");
        });
    }

    @Test
    public void ShouldRoundNotFoundPlayers2() {
        gam.add(item6);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            gam.round("Kolya", "Sveta");
        });
    }
}
