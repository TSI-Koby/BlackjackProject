package com.blackjack;
import java.util.Scanner;

public class Main {

    private Deck deck;
    private Player player;
    private Player dealer;
    private PlayerList playerList;

    public PlayerList getPlayerList() {
        return playerList;
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.initMain();
        main.playerTurn();
        main.dealerTurn();
    }

    public void initMain(){
        playerList = new PlayerList();
        player = new Player("Geoff");
        dealer = new Player("Dealer");
        playerList.addToPlayerList(player);
        playerList.addToPlayerList(dealer);
        deck = new Deck(1);
        Deck.shuffleDeck(deck);
        Deck.dealCards(deck, playerList);
        System.out.println(dealer.getName());
        System.out.println(Player.dealerCard(dealer));
        System.out.println(player.getName());
        System.out.println(Player.displayHand(player));
        Player.updateHandTotal(player);
    }

    public void playerTurn() {
        do {
            int input = Integer.parseInt(takeInput("1 for Hit, 2 for Stand"));
            switch(input) {
                case 1:
                    Player.hitMe(deck, player);
                    break;
                case 2:
                    Player.standMe(player);
                    break;
                default:
                    System.out.println("Unexpected input, please enter 1 or 2");
                    break;
            }
        }
        while(!player.getBustStatus() && !player.getStandStatus());
    }

    public void dealerTurn() {
        if(player.getBustStatus()) {
            System.out.println(dealer.getName() + " wins");
        }
        else if(player.getHandTotal() <= dealer.getHandTotal()) {
            System.out.println(dealer.getName() + " wins");
        }
        else {
            System.out.println("\nDealer's turn");
            System.out.println(Player.displayHand(dealer));
            Player.dealerRules(deck, dealer);
            if(dealer.getBustStatus())
                System.out.println(player.getName() + " wins");
            else if(player.getHandTotal() > dealer.getHandTotal())
                System.out.println(player.getName() + " wins");
            else
                System.out.println(dealer.getName() + " wins");
        }
    }


    public String takeInput(String inputRequest) {
        System.out.println("Enter " + inputRequest + " :");
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }
}
