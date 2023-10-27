package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player[] players = new Player[0];
    List<String> regList = new ArrayList<>();


    public void addPlayer(Player player) {

        Player[] temp = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            temp[i] = players[i];
        }
        temp[temp.length - 1] = player;
        players = temp;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not not found");
        }


        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not found");
        }


        if ((regList.contains(playerName1) != true)) throw new NotRegisteredException(
                "Player with name: " + playerName1 + " not registration");
        if (regList.contains(playerName2) != true) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName2 + " not registration");
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

    public Player[] findAll() {
        return players;
    }


}
