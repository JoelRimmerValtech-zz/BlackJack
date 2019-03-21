package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int playerScore = 0;
        int dealerScore = 0;

        while (true) {
            System.out.println();
            System.out.println("Welcome to the table, no counting please...");
            System.out.println("Here are you 2 cards from the dealer");
            System.out.println();

            ArrayList<String> suits = new ArrayList<>();
            suits.add("Hearts \u2665");
            suits.add("Diamonds \u2666");
            suits.add("Spades \u2660");
            suits.add("Clubs \u2663");

            ArrayList<Card> deck = new ArrayList<>();
            for (String suit : suits) {
                for (int i = 1; i <= 13; i++) {
                    deck.add(new Card(suit, i));
                }
            }

            Collections.shuffle(deck);

            PlayerHand player = new PlayerHand();
            PlayerHand dealer = new PlayerHand();

            for (int i = 0; i <= 1; i++) {
                Card card = deck.get(i);
                player.giveCard(card);
            }
            for (Card card : player.getListOfCards()) {
                System.out.println(card.toString());
            }

            System.out.println("Your total is: " + player.calculateHandTotal());

            int nextCardIndex = 2;
            while (player.calculateHandTotal() < 21) {
                System.out.print("Your total is less than 21, do you want to hit or stick: ");
                Scanner scanner = new Scanner(System.in);
                String userMove = scanner.next();
                if (userMove.equals("hit")) {
                    Card nextCard = deck.get(nextCardIndex);
                    nextCardIndex = nextCardIndex + 1;

                    player.giveCard(nextCard);
                    System.out.println(nextCard.toString());
                    System.out.println("Your new total is: " + player.calculateHandTotal());
                } else {
                    break;
                }
            }

            if (player.calculateHandTotal() > 21) {
                dealerScore = dealerScore + 1;
                System.out.println("You have gone bust - the dealer wins! " + playerScore + "-" + dealerScore);
                System.out.println("====================");
                continue;
            }

            for (int i = 0; i <= 1; i++) {
                Card card = deck.get(nextCardIndex);
                dealer.giveCard(card);
                nextCardIndex = nextCardIndex + 1;
                System.out.println("Dealer gets: " + card.toString());
            }

            while (dealer.calculateHandTotal() < player.calculateHandTotal()) {
                Card card = deck.get(nextCardIndex);
                dealer.giveCard(card);
                nextCardIndex = nextCardIndex + 1;
                System.out.println("Dealer gets: " + card.toString());
            }

            System.out.println("Dealer total is: " + dealer.calculateHandTotal());

            if (dealer.calculateHandTotal() > 21) {
                playerScore = playerScore + 1;
                System.out.println("Dealer has gone bust - you win! " + playerScore + "-" + dealerScore);
            } else if (dealer.calculateHandTotal() > player.calculateHandTotal()) {
                dealerScore = dealerScore + 1;
                System.out.println("Unlucky - the dealer has beaten you! " + playerScore + "-" + dealerScore);
            } else if (dealer.calculateHandTotal() == player.calculateHandTotal()) {
                dealerScore = dealerScore + 1;
                System.out.println("It's a draw - house wins! " + playerScore + "-" + dealerScore);
            } else if (dealer.calculateHandTotal() < player.calculateHandTotal()) {
                playerScore = playerScore + 1;
                System.out.println("Well done, you have beaten the dealer! " + playerScore + "-" + dealerScore);
            }

            System.out.println("====================");
        }
    }
}
