package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {


    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);

    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not registration");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not registration");
        }

        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        } else if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            return 2;
        } else
            return 0;

    }

    public Player findByName(String query) {
        for (Player player : players) {
            if (player.getName().equals(query)) {
                return player;
            }
        }
        return null;
    }

    public List<Player> findAll() {
        return players;
    }


}
