package com.blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;


class PlayerTest {

    @Test
    @DisplayName("hitMe test")
    void hitMe() {
        Player player = new Player("Geoff");
        Deck deck = new Deck(1);
        int handSizeBefore = player.getHand().size();
        Player.hitMe(deck, player);
        int handSizeAfter = player.getHand().size();
        assertEquals(handSizeBefore + 1, handSizeAfter, "hitMe test failure, incorrect handSizeAfter");
    }

    @Test
    @DisplayName("standStatus test")
    void standMe() {
        Player player = new Player("Geoff");
        Player.standMe(player);
        assertTrue(player.getStandStatus(), "standStatus test failure: incorrect standStatus");
    }

    @Test
    @DisplayName("updateHandTotal test")
    void updateHandTotal() {
        Player player = new Player("Geoff");
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

    @Test
    @DisplayName("bustStatus test")
    void updateBustStatus() {
        Player player = new Player("Geoff");
        Card card1 = new Card();
        card1.setCardValue(5);
        Card card2 = new Card();
        card2.setCardValue(7);
        Card card3 = new Card();
        card3.setCardValue(10);
        player.addToHand(card1);
        player.addToHand(card2);
        player.addToHand(card3);
        Player.updateHandTotal(player);
        assertTrue(player.getBustStatus());
    }

    @Test
    @DisplayName("dealerRules test")
    void dealerRules() {
        Player dealer = new Player("Geoff");
        Deck deck = new Deck(1);
        Card card1 = new Card();
        card1.createCard(5, "clubs", false);
        Card card2 = new Card();
        card2.createCard(7, "spades", false);
        dealer.addToHand(card1);
        dealer.addToHand(card2);
        Player.dealerRules(deck, dealer);
        assertTrue(dealer.getHand().size() > 2, "dealerRules test failure: expected size > 2," +
                " actual size: " + dealer.getHand().size());
        assertTrue(dealer.getStandStatus() || dealer.getBustStatus(), "dealerRules test failure: I'M SO ANGRY");
        List<Card> hand = new ArrayList<>();
        dealer.setHand(hand);
        dealer.setBustStatus(false);
        dealer.setStandStatus(false);
        Card card3 = new Card();
        card3.createCard(10, "hearts", true, "jack");
        Card card4 = new Card();
        card4.createCard(10, "diamonds", true, "queen");
        dealer.addToHand(card3);
        dealer.addToHand(card4);
        Player.dealerRules(deck, dealer);
        assertEquals(2, dealer.getHand().size(), "dealerRules test failure, expected size: 2," +
                " actual size: " + dealer.getHand().size());
        assertTrue(dealer.getStandStatus(), "dealerRules test failure, dealer not standing");
    }

    @Test
    @DisplayName("blackjackCheck test")
    void blackjackCheck() {
        Player player = new Player("Geoff");
        Card card1 = new Card();
        card1.setCardValue(1);
        Card card2 = new Card();
        card2.setFaceCard(true);
        player.addToHand(card1);
        player.addToHand(card2);
        assertTrue(Player.blackjackCheck(player), "blackjackCheck test failure: blackjack not identified");
    }

    @Test
    @DisplayName("displayHand test")
    void displayHand() {
        Player player = new Player("Geoff");
        Card card1 = new Card();
        card1.createCard(5, "hearts", false);
        player.addToHand(card1);
        assertEquals("[5♥] ", Player.displayHand(player), "displayHand test failure: expected [5♥] ," +
                " actual: " + Player.displayHand(player));
    }

    @Test
    @DisplayName("get/set name test")
    void getName() {
        Player player = new Player("Geoff");
        player.setName("Tony");
        assertEquals("Tony", player.getName(), "get/set name test failure");
    }
}
