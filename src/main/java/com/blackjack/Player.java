package com.blackjack;
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class Player {

    private List<Card> hand = new ArrayList<>();
    private boolean standStatus = false;
    private int handTotal = 0;
    private boolean bustStatus = false;

    public List<Card> getHand() {
        return hand;
    }
    public void setHand(List<Card> hand) {
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

    public static boolean blackjackCheck(Player player) {
        Card card1 = player.getHand().get(0);
        Card card2 = player.getHand().get(1);
        return (card1.isFaceCard() && card2.getCardValue() == 1) || (card2.isFaceCard() && card1.getCardValue() == 1);
    }

    public static String displayHand(Player player) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Card c : player.getHand()) {
            String suit;
            switch(c.getCardSuit()) {
                case "hearts":
                    suit = "♥";
                    break;
                case "diamonds":
                    suit = "♦";
                    break;
                case "clubs":
                    suit = "♣";
                    break;
                case "spades":
                    suit = "♠";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + c.getCardSuit());
            }
            if(c.isFaceCard()) {
                stringBuilder.append("[").append(c.getFaceCardType()).append(suit).append("] ");
            }
            else {
                stringBuilder.append("[").append(c.getCardValue()).append(suit).append("] ");
            }
        }
        return stringBuilder.toString();
    }
}
