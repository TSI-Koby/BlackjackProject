package com.blackjack;
import java.util.ArrayList;

public class PlayerList {
    private ArrayList<Player> currentPlayers = new ArrayList<>();

    public ArrayList<Player> getCurrentPlayers() {
        return currentPlayers;
    }
    public void setCurrentPlayers(ArrayList<Player> currentPlayers) {
        this.currentPlayers = currentPlayers;
    }
    public void addToPlayerList(Player player) {
        currentPlayers.add(player);
    }
}
