package BlackJack;

public class Card {

    private String suit;
    private int value;

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        if (value == 1) {
            return "Ace of " + suit;
        }
        else if (value == 11) {
            return "Jack of " + suit;
        }
        else if (value == 12) {
            return "Queen of " + suit;
        }
        else if (value == 13) {
            return "King of " + suit;
        }
        else {
            return value + " of " + suit;
        }
    }

    public int getBlackjackValue() {
        if (value > 10) {
            return 10;
        } else if (value == 1) {
            return 11;
        }
        return value;
    }
}
