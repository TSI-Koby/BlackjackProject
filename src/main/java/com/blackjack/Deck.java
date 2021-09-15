package com.blackjack;
import java.util.Stack;
import java.util.Collections;

public class Deck {

    public static Stack<Card> createDeck() {
        Stack<Card> deck = new Stack<>();
        String[] suits = new String[]{"hearts", "diamonds", "clubs", "spades"};
        for(String s : suits) {
            for (int i = 1; i < 14; i++) {
                Card card = new Card();
                card.setCardSuit(s);
                card.setCardValue(i);
                if (i > 10) {
                    card.setFaceCard(true);
                }
                if (i == 11) {
                    card.setFaceCardType("jack");
                    card.setCardValue(10);
                }
                if (i == 12) {
                    card.setFaceCardType("queen");
                    card.setCardValue(10);
                }
                if (i == 13) {
                    card.setFaceCardType("king");
                    card.setCardValue(10);
                }
                deck.push(card);
            }
        }
    return deck;
    }

    public static void shuffleDeck(Stack<Card> deck) {
        Collections.shuffle(deck);
    }
    public static void dealCards(Stack<Card> deck, PlayerList playerList) {
        for(Player p: playerList.getPlayerList()) {
            p.addToHand(deck.pop());
            p.addToHand(deck.pop());
        }
    }
}
