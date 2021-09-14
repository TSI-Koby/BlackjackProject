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
        Stack<Card> deckShuffled = deck;
        Deck.shuffleDeck(deckShuffled);
        Object[] deckA = deck.toArray();
        Object[] deck2A = deckShuffled.toArray();
        assertNotEquals(deckA, deck2A, "still broken bozo");
    }
}
