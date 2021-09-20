package com.blackjack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("initMain test")
    void initMain() {
        Main.initMain();
    }

    @Test
    @DisplayName("playerTurn test")
    void playerTurn() {
        Main.playerTurn();
    }

    @Test
    @DisplayName("dealerTurn test")
    void dealerTurn() {
        Main.dealerTurn();
    }
}