package com.blackjack;
import java.util.ArrayList;
import java.util.Stack;

public class Player {

    private ArrayList<Card> hand = new ArrayList<>();
    private boolean standStatus = false;
    private int handTotal = 0;
    private boolean bustStatus = false;

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
    public int getHandTotal() {
        return handTotal;
    }
    public void setHandTotal(int handTotal) {
        this.handTotal = handTotal;
    }
    public boolean getBustStatus() {
        return bustStatus;
    }
    public void setBustStatus(boolean bustStatus) {
        this.bustStatus = bustStatus;
    }

    public static void hitMe(Player player, Stack<Card> deck) {
        player.addToHand(deck.pop());
    }

    public static void standMe(Player player) {
        player.setStandStatus(true);
    }

    public static void updateHandTotal(Player player) {
        int tempHandTotal = 0;
        for(Card c : player.getHand()) {
            int value = c.getCardValue();
            tempHandTotal += value;
        }
        player.setHandTotal(tempHandTotal);
        if(tempHandTotal > 21)
            player.setBustStatus(true);
    }

    public static void dealerRules(Player player, Stack<Card> deck) {
        while (player.getHandTotal() < 17) {
            hitMe(player, deck);
            updateHandTotal(player);
        }
        player.setStandStatus(true);
    }
}
