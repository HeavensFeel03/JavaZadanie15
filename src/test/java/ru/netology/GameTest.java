package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class GameTest {
    Game gam = new Game();
    //  List<String> regList = new ArrayList<>();
    Player item1 = new Player(3, "Kolya", 7);
    Player item2 = new Player(4, "Petya", 8);
    Player item3 = new Player(6, "Vlad", 9);
    Player item4 = new Player(9, "Arkadii", 4);
    Player item5 = new Player(11, "Slava", 8);
    Player item6 = new Player(33, "Sasha", 10);
    Player item7 = new Player(90, "Evgenii", 20);
    Player item8 = new Player(96, "Sveta", 2000);

    @BeforeEach
    public void setup() {

        gam.register(item1);
        gam.register(item2);
        gam.register(item3);
        gam.register(item4);
        gam.register(item5);
        gam.register(item6);
        gam.register(item7);
    }


    @Test
    public void shouldAllRegisteredPlayers() {
        Player[] expected = {item1, item2, item3, item4, item5, item6, item7};
        Player[] actual = gam.findAll().toArray(new Player[0]);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRoundPlayers2() {
        int expected = 2;
        int actual = gam.round(item1.getName(), item2.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundPlayers1() {
        int expected = 1;
        int actual = gam.round(item3.getName(), item4.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundPlayers0() {
        int expected = 0;
        int actual = gam.round(item5.getName(), item2.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldRoundNotRegisterPlayers1() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            gam.round("Sveta", "Kolya");
        });
    }

    @Test
    public void ShouldRoundNotRegisterPlayers2() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            gam.round("Kolya", "Sveta");
        });
    }


}
