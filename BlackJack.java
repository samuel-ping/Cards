import java.util.*;

public class BlackJack {
    private boolean stand;
    private Deck deck;
    private Hand dealer;
    private Hand player;

    public BlackJack() {
        stand = false;
        deck = new Deck();
        deck.shuffle(1000);
        dealer = new Hand();
        dealer.addCard(deck.drawCard(2));
        player = new Hand();
        player.addCard(deck.drawCard(2));
    }

    public void playGame() {
        Scanner in = new Scanner(System.in);
        String input = "";

        int playerTotal = 0;
        int dealerTotal = 0;

        while(stand==false) {
            displayHands();
            
            playerTotal = player.addBlackJackValues();
            dealerTotal = dealer.addBlackJackValues();

            System.out.println("Your total: " + playerTotal);

            if(playerTotal>=21) {
                break;
            }

            System.out.print("[H]it or [S]tand?: ");
            input = in.nextLine().toLowerCase();

            if(input.equals("h")) {
                player.addCard(deck.drawCard());
            } else {
                stand = true;
            }
        }

        if(!(playerTotal>=21)) {
            while(dealerTotal<18) {
                displayAllHands();
                System.out.println("Dealer Total: " + dealerTotal);
                System.out.println("Your Total: " + playerTotal);

                System.out.println();

                dealer.addCard(deck.drawCard());
                dealerTotal = dealer.addBlackJackValues();
            }
        }

        System.out.println();
        displayAllHands();
        System.out.println("Dealer Total: " + dealerTotal);
        System.out.println("Your Total: " + playerTotal);

        if(playerTotal>21) {
            System.out.println("You lose!");
        } else if(playerTotal>dealerTotal || dealerTotal>21) {
            System.out.println("You win!");
        } else if(dealerTotal>playerTotal) {
            System.out.println("You lose!");
        } else {
            System.out.println("It's a tie!");
        }

        in.close();
    }

    /*
    * Displays cards, without showing one of the dealer's cards
    */
    public void displayHands() {
        System.out.println("Dealer: ? " + dealer.showACard(1));
        System.out.println("Your hand: " + player.showCards());
        System.out.println();
    }

    /*
    * Shows all cards including dealer's cards
    */
    public void displayAllHands() {
        System.out.println("Dealer: " + dealer.showCards());
        System.out.println("Your hand: " + player.showCards());
    }
}