package com.blackjack;
import java.util.Stack;

public class Deck {

    public static Stack<Card> createDeck() {
        Stack<Card> deck = new Stack<>();
        for(int i = 1; i < 14; i++){
            Card card = new Card();
            card.setCardSuit("hearts");
            card.setCardValue(i);
            if(i > 10) {
                card.setFaceCard(true);
            }
            if(i == 11) {
                card.setFaceCardType("jack");
            }
            if(i == 12) {
                card.setFaceCardType("queen");
            }
            if(i == 13) {
                card.setFaceCardType("king");
            }
            deck.push(card);
        }
        for(int i = 1; i < 14; i++){
            Card card = new Card();
            card.setCardSuit("diamonds");
            card.setCardValue(i);
            if(i > 10) {
                card.setFaceCard(true);
            }
            if(i == 11) {
                card.setFaceCardType("jack");
            }
            if(i == 12) {
                card.setFaceCardType("queen");
            }
            if(i == 13) {
                card.setFaceCardType("king");
            }
            deck.push(card);
        }
        for(int i = 1; i < 14; i++){
            Card card = new Card();
            card.setCardSuit("clubs");
            card.setCardValue(i);
            if(i > 10) {
                card.setFaceCard(true);
            }
            if(i == 11) {
                card.setFaceCardType("jack");
            }
            if(i == 12) {
                card.setFaceCardType("queen");
            }
            if(i == 13) {
                card.setFaceCardType("king");
            }
            deck.push(card);
        }
        for(int i = 1; i < 14; i++){
            Card card = new Card();
            card.setCardSuit("spades");
            card.setCardValue(i);
            if(i > 10) {
                card.setFaceCard(true);
            }
            if(i == 11) {
                card.setFaceCardType("jack");
            }
            if(i == 12) {
                card.setFaceCardType("queen");
            }
            if(i == 13) {
                card.setFaceCardType("king");
            }
            deck.push(card);
        }
    return(deck);
    }
}
