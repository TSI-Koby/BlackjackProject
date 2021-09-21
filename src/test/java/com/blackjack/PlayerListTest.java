package com.blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerListTest {

    @Test
    @DisplayName("getCurrentPlayers test")
    void getCurrentPlayers() {
        PlayerList playerList = new PlayerList();
        List<Player> currentPlayers = new ArrayList<>();
        Player player = new Player("Geoff");
        currentPlayers.add(player);
        playerList.setCurrentPlayers(currentPlayers);
        assertTrue(playerList.getCurrentPlayers().size() > 0, "player not added to playerList");
    }
}