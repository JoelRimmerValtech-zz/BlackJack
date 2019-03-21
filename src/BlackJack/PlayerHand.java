package BlackJack;

import java.util.ArrayList;

public class PlayerHand {

    private ArrayList<Card> listOfCards = new ArrayList<>();

    public ArrayList<Card> getListOfCards() {
        return listOfCards;
    }

    public void giveCard(Card card) {
        listOfCards.add(card);
    }

    public int calculateHandTotal() {
        int totalOfCards = 0;
        for (Card card : listOfCards) {
            totalOfCards = totalOfCards + card.getBlackjackValue();
        }
        for (int i = 0; i < numberOfAces(); i++) {
            if (totalOfCards > 21) {
                totalOfCards = totalOfCards - 10;
            }
        }
        return totalOfCards;
    }

    private int numberOfAces() {
        int numberOfAces = 0;
        for (Card card : listOfCards) {
            if (card.getValue() == 1) {
                numberOfAces = numberOfAces + 1;
            }
        }
        return numberOfAces;
    }
}
