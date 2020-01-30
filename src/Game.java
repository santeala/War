import java.util.Scanner;
import java.util.ArrayList;

public class Game {

    static Hand computer = new Hand();
    static Hand player = new Hand();
    static Deck deck = new Deck();
    static ArrayList<Card> pot = new ArrayList<Card>();
    static Scanner read = new Scanner(System.in);

    public static void setup(){
        //shuffle
        deck.shuffle();

        //deal
        for(int i = 0; deck.cardsLeft() > 0; i++){
            computer.addCard(deck.deal());
            player.addCard(deck.deal());
        }
    }

    public static void playCards(){
        pot.add(0, computer.getCard(0));
        computer.removeCard(0);
        pot.add(1,player.getCard(1));
        player.removeCard(1);
        System.out.println("Computer Player: " + pot.get(0));
        System.out.println("Player Played: " + pot.get(1));
    }

    public static void checkWin(){
        if(pot.get(0).getRank() > pot.get(1).getRank()){
            for(Card card: pot){
                computer.addCard(card);
            }
            pot.clear();

            System.out.println("You Lost");
            System.out.println("You have " + player.getCardCount() + " cards in your hand.");
            System.out.println("Press enter to continue");
            read.nextLine();
        }else if(pot.get(0).getRank() < pot.get(1).getRank()){
            for(Card card: pot){
                player.addCard(card);
            }
            pot.clear();

            System.out.println("You won.");
            System.out.println("You have " + player.getCardCount() + "cards in your hand.");
            System.out.println("Press enter to continue");
            read.nextLine();
        }else{
            System.out.println("MATCH!!");
            System.out.println("Press enter to continue");
            read.nextLine();
            playCards();;
            checkWin();
        }
    }

    public static void main(String[] args){
        setup();
        do{
            playCards();
            checkWin();
        }while(computer.getCardCount() > 0 && player.getCardCount() > 0);

        if(computer.getCardCount() > 0){
            System.out.println("You lost the game.");
        }else
            System.out.println("You've WON!");
    }

}
