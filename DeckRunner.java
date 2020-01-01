public class DeckRunner {
    public static void main(String[] args) {
        // ArrayDeck deck = new ArrayDeck();
        // System.out.println(deck);
        // deck.shuffle(1000);
        // System.out.println(deck);

        Deck deck = new Deck();
        // System.out.println(deck + "\n\n");


        deck.shuffle(1000);
        // System.out.println(deck + "\n\n");
        BlackJack game = new BlackJack();
        game.playGame();

        // System.out.println(deck.drawCard(5));
    }
}