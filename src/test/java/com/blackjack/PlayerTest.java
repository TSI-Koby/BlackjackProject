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

    @Test
    @DisplayName("updateHandTotal test")
    void updateHandTotal() {
        Player player = new Player();
        Card card1 = new Card();
        card1.setCardValue(5);
        Card card2 = new Card();
        card2.setCardValue(7);
        player.addToHand(card1);
        player.addToHand(card2);
        Player.updateHandTotal(player);
        assertEquals(12, player.getHandTotal(),
                "updateHandTotal failure: expected: 12, actual: " + player.getHandTotal());
    }
}
