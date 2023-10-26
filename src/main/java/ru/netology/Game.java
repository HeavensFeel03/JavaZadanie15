package ru.netology;

import java.util.ArrayList;

public class Game {

    private Player[] players = new Player[0];


    public void add(Player player) {

        Player[] temp = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            temp[i] = players[i];
        }
        temp[temp.length - 1] = player;
        players = temp;
    }
    /*private Player[] addToPlayers(Player[] current, Player player) {
        Player[] tmp = new Player[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = player;
        return tmp;
    }*/

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not not found");
        }


        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not found");
        }


        if (register(playerName1) == 0) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not registration");
        }
        if (register(playerName2) == 0) {
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

    public int register(String player) {
        ArrayList<String> regList = new ArrayList<>();
        regList.add("Kolya");
        regList.add("Petya");
        regList.add("Vlad");
        regList.add("Arkadii");
        regList.add("Slava");
        for (int i = 0; i < regList.size(); i++) {
            if (regList.get(i).equals(player)) {
                return 1;
            }
        }
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
