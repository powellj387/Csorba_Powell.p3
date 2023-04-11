package war;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class War {
    public static final int CARDS_IN_WAR = 3;
    private Random random;
    private ConsoleInterface ui;

    public War(int seed, ConsoleInterface ui){
        random = new Random(seed);
        ui = ui;

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
                    List<Card> warCards1 = new ArrayList<>();
                    List<Card> warCards2 = new ArrayList<>();

                    warCards1.add(card1);
                    warCards2.add(card2);
                    for (int i = 0; i < CARDS_IN_WAR; ++i) {
                        warCards1.add(player1.playCard());
                        warCards2.add(player2.playCard());
                    }
                    int warComparison = warCards1.get();
                }
            }


            // Each player plays 2 face-down card and a face-up card

            // Determine the winner of the war

            // Another war occurs ie last two of the cards before also are same rank

            // One player doesn't have enough cards for another war

            // Determine the winner of the game and display the results

        }


    }

    public void testPlayGame(Player player1, Player player2){

    }
}
