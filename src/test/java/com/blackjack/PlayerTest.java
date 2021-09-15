package com.blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

public class PlayerTest {

    @Test
    @DisplayName("hitMe test")
    void hitMe() {
        Player player = new Player();
        Stack<Card> deck = Deck.createDeck();
        int handSizeBefore = player.getHand().size();
        Player.hitMe(player, deck);
        int handSizeAfter = player.getHand().size();
        assertEquals(handSizeBefore + 1, handSizeAfter, "hitMe test failure, incorrect handSizeAfter");
    }

    @Test
    @DisplayName("standStatus test")
    void standMe() {
        Player player = new Player();
        Player.standMe(player);
        assertTrue(player.getStandStatus(), "standStatus test failure: incorrect standStatus");
    }
}
