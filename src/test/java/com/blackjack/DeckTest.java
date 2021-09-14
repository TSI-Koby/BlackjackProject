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
        assertEquals(52, deck.size(), "createDeck incorrect size");
        assertNotNull(deck.peek(), "createDeck failure: deck empty");
    }

    @Test
    @DisplayName("shuffleDeck test")
    void shuffleDeck() {
        Stack<Card> deck = Deck.createDeck();
        Stack<Card> deck2 = Deck.shuffleDeck(deck);
        Object[] deckA = deck.toArray();
        Object[] deck2A = deck2.toArray();
        assertNotEquals(deckA, deck2A, "still broken bozo");
    }
}
