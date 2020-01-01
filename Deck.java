import java.util.*;

public class Deck {
    private Stack<Card> deck;

    /*
    * Initializes a new, sorted deck
    */
    public Deck() {
        deck = new Stack<Card>();
        String suit = "";
        for(int i = 1; i <= 13; i++) {
            for(int j = 1; j <= 4; j++) {
                if(j == 1) {
                    suit = "clubs";
                } else if(j == 2) {
                    suit = "spades";
                } else if(j == 3) {
                    suit = "hearts";
                } else {
                    suit = "diamonds";
                }
                deck.push(new Card(i, suit));
            }
        }
    }

    /*
    * Shuffles the cards in the deck by swapping cards x amount of times
    */
    public void shuffle(int swaps) {
        Card[] deckArr = new Card[this.getDeckSize()];
        Stack<Card> tempDeck = (Stack<Card>) this.deck.clone();

        // gets an array version of the current deck
        for(int i = 0; i < deckArr.length; i++) {
            deckArr[i] = tempDeck.pop();
        }
        // now tempDeck should be an empty stack

        int card1Pos = -1;
        int card2Pos = -1;

        // swapping two random cards at a time, x times
        for(int i = 0; i < swaps; i++) {
            card1Pos = (int)(Math.random() * 52);
            card2Pos = (int)(Math.random() * 52);
            swap(deckArr, card1Pos, card2Pos);
        }

        // converts array version of deck back to a stack, reusing the tempDeck stack
        for(int i = 0; i < deckArr.length; i++) {
            tempDeck.push(deckArr[i]);
        }

        this.deck = (Stack<Card>) tempDeck.clone();
    }

    /*
    * This swaps two cards within an array, given the two indices of the cards as well as the deck
    */
    private Card[] swap(Card[] deck, int card1Pos, int card2Pos) {
        Card temp = deck[card1Pos];
        deck[card1Pos] = deck[card2Pos];
        deck[card2Pos] = temp;
        return deck;
    }

    /*
    * Draws the top card in the deck
    */
    public Card drawCard() {
        return deck.pop();
    }

    /*
    * Draws x cards from the top of the deck
    */
    public Card[] drawCard(int numCards) {
        Card[] cards = new Card[numCards];
        for(int i = 0; i < numCards; i++) {
            cards[i] = this.drawCard();
        }
        return cards;
    }

    /*
    * This returns the number of cards in the deck
    */
    public int getDeckSize() {
        return this.deck.size();
    }

    public String toString() {
        String output = "";
        int originalSize = this.getDeckSize();
        Stack<Card> tempDeck = (Stack<Card>) this.deck.clone();

        for(int i = 0; i < originalSize; i++) {
            output += tempDeck.pop() + " ";
        }

        return output;
    }
}