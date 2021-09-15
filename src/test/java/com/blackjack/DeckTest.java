package com.blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Stack;


class DeckTest {

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
        assertNotEquals(deckA, deck2A, "shuffleDeck failure: deck not shuffled");
    }

    @Test
    @DisplayName("dealCards test")
    void dealCards() {
        Stack<Card> deck = Deck.createDeck();
        Player player = new Player();
        PlayerList players = new PlayerList();
        players.addToPlayerList(player);
        Deck.dealCards(deck, players);
        for(Player p : players.getCurrentPlayers()) {
            assertEquals(2, p.getHand().size(), "dealCards failure: incorrect hand size");
        }
    }

    @Test
    @DisplayName("reclaimCards test")
    void reclaimCards() {
        Stack<Card> deck = Deck.createDeck();
        Player player = new Player();
        PlayerList players = new PlayerList();
        players.addToPlayerList(player);
        Deck.dealCards(deck, players);
        Deck.reclaimCards(players, deck);
        for(Player p : players.getCurrentPlayers()) {
            assertEquals(0, p.getHand().size(), "reclaimCards test failure: expected 0, actual: " +
                    p.getHand().size());
        }
        assertEquals(52, deck.size(), "reclaimCards test failure: expected 52, actual: " + deck.size());
    }
}
