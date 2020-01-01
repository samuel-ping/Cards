import java.util.*;

public class Hand {
    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    /*
    * Adds a card to the hand
    */
    public void addCard(Card card) {
        hand.add(card);
    }

    /*
    * Adds multiple cards to hand at once
    */
    public void addCard(Card[] cards) {
        for(int i = 0; i < cards.length; i++) {
            this.addCard(cards[i]);
        }
    }

    /*
    * Removes a card from the hand using its index. Note that 1 is subtracted
    * from the index to correspond with Java's 0 index system
    */
    public void removeCard(int index) {
        hand.remove(index-1);
    }

    public Card checkLast() {
        return hand.get(hand.size());
    }

    /*
    * Adds up all the numerical values of the cards in the hand
    */
    public int addValues() {
        int total = 0;
        Iterator<Card> iter = hand.listIterator();

        while(iter.hasNext()) {
            total += iter.next().getNumValue();
        }

        return total;
    }

    /*
    * Adds up all the numerical values of the cards in the hand 
    * for the game BlackJack, so all face cards are worth 10 points,
    * and aces can be worth either 11 or 1
    */
    public int addBlackJackValues() {
        int total = 0;
        Card currCard = new Card();
        Iterator<Card> iter = hand.listIterator();
        int currIndex = 0;

        while(iter.hasNext()) {
            currCard = iter.next();
            if(currCard.getValue().equals("ace")) {
                this.moveCardToEnd(currIndex);
            }
        }

        Iterator<Card> iter2 = hand.listIterator();
        while(iter2.hasNext()) {
            currCard = iter2.next();
            if(currCard.getNumValue()>10) {
                total += 10;
            } else if(currCard.getValue().equals("ace")) {
                if(total+11>21) {
                    total += currCard.getNumValue();
                } else {
                    total += 11;
                }
            } else {
                total += currCard.getNumValue();
            }
        }

        return total;
    }

    /*
    * Same thing as .toString(), except this also shows the index of the cards.
    * Note that the index starts at 1 for the user's ease of use.
    */
    public String showCards() {
        String output = "";
        int counter = 1;
        Iterator<Card> iter = hand.listIterator();

        while(iter.hasNext()) {
            output += iter.next().toString() + "[" + counter + "]" + " ";
            counter += 1;
        }

        return output;
    }

    /*
    * Shows a specific card
    */
    public String showACard(int index) {
        return hand.get(index).toString();
    }

    /*
    * Moves a card to the righthandmost side of the hand
    */
    public void moveCardToEnd(int index) {
        Card temp = hand.get(index); // temp becomes the card that is being moved to the end
        hand.add(temp);
        hand.remove(index);
    }

    public String toString() {
        String output = "";
        Iterator<Card> iter = hand.listIterator();

        while(iter.hasNext()) {
            output += iter.next().toString() + " ";
        }

        return output;
    }

    // Gotta relearn Comparator class
    // public void sortHand() {
    //     hand.sort();
    // }

    public static void main(String[] args) {
        Hand hand = new Hand();
        Deck deck = new Deck();
        deck.shuffle(1000);
        hand.addCard(deck.drawCard(5));
        System.out.println(hand.showCards());
        hand.moveCardToEnd(2);
        System.out.println(hand.showCards());
    }
}