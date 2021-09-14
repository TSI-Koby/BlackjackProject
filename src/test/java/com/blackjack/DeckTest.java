package com.blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Stack;


public class DeckTest {

    @Test
    @DisplayName("createDeck test")
    void createDeck() {
        Stack<Card> deck = Deck.createDeck();
        assertTrue(deck instanceof Stack, "createDeck incorrect type");
        assertEquals(52, deck.size(), "createDeck incorrect size");
        assertTrue(deck.peek() instanceof Card, "createDeck incorrect entry type");
    }
}
