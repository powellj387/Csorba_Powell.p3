package war;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class War {
    public static final int CARDS_IN_WAR = 3;
    private Random random;
    private ConsoleInterface userinterface;



    public War(int seed, ConsoleInterface ui){
        random = new Random(seed);
        userinterface = ui;
    }

    public void playGame(){
        Deck deck = new Deck();
        deck.shuffle(random);

        // Create two players and deal the cards to them
        Player player1 = new Player();
        Player player2 = new Player();
        while(!deck.empty()){
            player1.takeCard(deck.dealCard());
            player2.takeCard(deck.dealCard());
        }

        // Play the game until one player runs out of cards
        while(player1.cardsInHand() != 0 && player2.cardsInHand() != 0){
            // Each player plays a card
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            // Determine the winner of the battle
            int comparison = card1.compareRanks(card2);
            if (comparison > 0){
                player1.takeCard(card1);
                player1.takeCard(card2);
            } else if (comparison < 0) {
                player2.takeCard(card1);
                player2.takeCard(card2);
            }else{
                // if A war occurs and both have enough cards to do said war
                if(player1.cardsInHand() >= CARDS_IN_WAR && player2.cardsInHand() >= CARDS_IN_WAR) {
                    ULQueue<Card> warCards1 = new ULQueue<>();
                    ULQueue<Card> warCards2 = new ULQueue<>();

                    // Each player plays 2 face-down card and a face-up card
                    for (int i = 0; i < CARDS_IN_WAR; ++i) {
                        warCards1.push(player1.playCard());
                        warCards2.push(player2.playCard());
                    }
                    warCards1.push(card1);
                    warCards2.push(card2);

                    // Determine the winner of the war
                    int warComparison = warCards1.pop().compareRanks(warCards2.pop());
                    while (warComparison == 0) {
                        // Another war occurs
                        if (player1.cardsInHand() < CARDS_IN_WAR + 1 || player2.cardsInHand() < CARDS_IN_WAR + 1) {
                            // One player doesn't have enough cards for another war
                            break;
                        }

                        // Each player plays 2 face-down cards and a face-up card
                        for (int i = 0; i < CARDS_IN_WAR; i++) {
                            warCards1.push(player1.playCard());
                            warCards2.push(player2.playCard());
                        }
                        warCards1.push(player1.playCard());
                        warCards2.push(player2.playCard());

                        // Determine the winner of the next battle
                        warComparison = warCards1.pop().compareRanks(warCards2.pop());
                    }

                    if (warComparison > 0){
                        // Player 1 wins the war
                        while (!warCards1.empty()) {
                            player1.takeCard(warCards1.pop());
                        }
                        while (!warCards2.empty()) {
                            player1.takeCard(warCards2.pop());
                        }
                    } else {
                        // Player 2 wins the war
                        while (!warCards1.empty()) {
                            player2.takeCard(warCards1.pop());
                        }
                        while (!warCards2.empty()) {
                            player2.takeCard(warCards2.pop());
                        }
                    }
                }
            }
            // Determine the winner of the game and display the results
            if (player1.cardsInHand() == 0 || player2.cardsInHand() == 0) {
                userinterface.displayGameOver(player1.cardsInHand(), player2.cardsInHand());
            }
        }
    }

    public void testPlayGame(Player player1, Player player2){
        // Play the game until one player runs out of cards
        while(player1.cardsInHand() != 0 && player2.cardsInHand() != 0){
            // Each player plays a card
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            // Determine the winner of the battle
            int comparison = card1.compareRanks(card2);
            if (comparison > 0){
                player1.takeCard(card1);
                player1.takeCard(card2);
            } else if (comparison < 0) {
                player2.takeCard(card1);
                player2.takeCard(card2);
            }else{
                // if A war occurs and both have enough cards to do said war
                if(player1.cardsInHand() >= CARDS_IN_WAR && player2.cardsInHand() >= CARDS_IN_WAR) {
                    ULQueue<Card> warCards1 = new ULQueue<>();
                    ULQueue<Card> warCards2 = new ULQueue<>();

                    // Each player plays 2 face-down card and a face-up card
                    for (int i = 0; i < CARDS_IN_WAR; ++i) {
                        warCards1.push(player1.playCard());
                        warCards2.push(player2.playCard());
                    }
                    warCards1.push(card1);
                    warCards2.push(card2);

                    // Determine the winner of the war
                    int warComparison = warCards1.pop().compareRanks(warCards2.pop());
                    while (warComparison == 0) {
                        // Another war occurs
                        if (player1.cardsInHand() < CARDS_IN_WAR + 1 || player2.cardsInHand() < CARDS_IN_WAR + 1) {
                            // One player doesn't have enough cards for another war
                            break;
                        }

                        // Each player plays 2 face-down cards and a face-up card
                        for (int i = 0; i < CARDS_IN_WAR; i++) {
                            warCards1.push(player1.playCard());
                            warCards2.push(player2.playCard());
                        }
                        warCards1.push(player1.playCard());
                        warCards2.push(player2.playCard());

                        // Determine the winner of the next battle
                        warComparison = warCards1.pop().compareRanks(warCards2.pop());
                    }

                    if (warComparison > 0){
                        // Player 1 wins the war
                        while (!warCards1.empty()) {
                            player1.takeCard(warCards1.pop());
                        }
                        while (!warCards2.empty()) {
                            player1.takeCard(warCards2.pop());
                        }
                    } else {
                        // Player 2 wins the war
                        while (!warCards1.empty()) {
                            player2.takeCard(warCards1.pop());
                        }
                        while (!warCards2.empty()) {
                            player2.takeCard(warCards2.pop());
                        }
                    }
                }
            }
            if (player1.cardsInHand() == 0 || player2.cardsInHand() == 0) {
                userinterface.displayGameOver(player1.cardsInHand(), player2.cardsInHand());
            }
        }
    }
}
