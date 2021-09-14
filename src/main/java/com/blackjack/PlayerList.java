package com.blackjack;
import java.util.ArrayList;

public class PlayerList {
    private ArrayList<Player> playerList = new ArrayList<>();

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }
    public void addToPlayerList(Player player) {
        playerList.add(player);
    }
}
