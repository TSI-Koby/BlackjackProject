package com.blackjack;
import java.util.ArrayList;
import java.util.Stack;

public class Player {

    private ArrayList<Card> hand = new ArrayList<>();
    private boolean standStatus = false;

    public ArrayList<Card> getHand() {
        return hand;
    }
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    public void addToHand(Card card) {
        hand.add(card);
    }
    public boolean getStandStatus() {
        return standStatus;
    }
    public void setStandStatus(boolean standStatus) {
        this.standStatus = standStatus;
    }

    public static void hitMe(Player player, Stack<Card> deck) {
        player.addToHand(deck.pop());
    }

    public static void standMe(Player player) {
        player.setStandStatus(true);
    }
}
