public class Card {
    private int value;
    private String suit;

    public Card() {
        value = -1;
        suit = "";
    }
    
    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getNumValue() {
        return value;
    }

    public String getValue() {
        if(value == 1) return "ace";
        if(value == 11) return "jack";
        if(value == 12) return "queen";
        if(value == 13) return "king";
        return Integer.toString(value);
    }

    public String getSymbolValue() {
        if(value == 1) return "A";
        if(value == 11) return "J";
        if(value == 12) return "Q";
        if(value == 13) return "K";
        return Integer.toString(value);
    }

    public String getSuit() {
        return suit;
    }

    public String toString() {
        String output = this.getSymbolValue() + this.getSuit();
        return output;
    }
}