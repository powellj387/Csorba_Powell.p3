//@authors Alex Csorba and Julian Powell
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

    public void playGame() {
        int battlesPlayed = 0;
        Deck deck = new Deck();
        deck.shuffle(random);

        // Create two players and deal the cards to them
        Player player1 = new Player();
        Player player2 = new Player();
        while (!deck.empty()) {
            player1.takeCard(deck.dealCard());
            player2.takeCard(deck.dealCard());
        }

        //Displays that a new game has been started
        userinterface.newGame();

        // Play the game until one player runs out of cards
        while (player1.cardsInHand() != 0 && player2.cardsInHand() != 0) {
            // Each player plays a card
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();
            userinterface.displaySingleCardBattle(card1, card2);

            // Determine the winner of the battle
            int battleComp = card1.compareRanks(card2);

            if(battleComp>0){
                player1.takeCard(card1);
                player1.takeCard(card2);
            } else if (battleComp<0) {
                player2.takeCard(card2);
                player2.takeCard(card1);
            }else {
                ULStack<Card> warCards1 = new ULStack<>();
                ULStack<Card> warCards2 = new ULStack<>();

                while (battleComp==0){
                 // Each player plays 2 face-down card and a face-up card
                    for(int i = 0; i<CARDS_IN_WAR;++i){
                        warCards1.push(player1.playCard());
                        warCards2.push(player2.playCard());
                    }

                    userinterface.displayWar(CARDS_IN_WAR-1,warCards1.top(),CARDS_IN_WAR-1,warCards2.top());

                    // Determine the winner of the war
                    battleComp = warCards1.top().compareRanks(warCards2.top());

                    if(battleComp>0){
                        while(warCards1.size()!=0){
                            player1.takeCard(warCards1.pop());
                        }
                        player1.takeCard(card1);
                        while(warCards2.size()!=0){
                            player1.takeCard(warCards2.pop());
                        }
                        player1.takeCard(card2);
                    }
                    else if (battleComp<0) {
                        while(warCards2.size()!=0){
                            player2.takeCard(warCards2.pop());
                        }
                        player2.takeCard(card2);

                        while(warCards1.size()!=0){
                            player2.takeCard(warCards1.pop());
                        }
                        player2.takeCard(card1);
                    }
                }
            }
            userinterface.displayPostBattleScores(player1.cardsInHand(), player2.cardsInHand());
        }
        userinterface.displayGameOver(player1.cardsInHand(),player2.cardsInHand());
}

    public void testPlayGame(Player player1, Player player2){
        //Displays that a new game has been started
        userinterface.newGame();

        // Play the game until one player runs out of cards
        while (player1.cardsInHand() != 0 && player2.cardsInHand() != 0) {
            // Each player plays a card
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();
            userinterface.displaySingleCardBattle(card1, card2);

            // Determine the winner of the battle
            int battleComp = card1.compareRanks(card2);

            if(battleComp>0){
                player1.takeCard(card1);
                player1.takeCard(card2);
            } else if (battleComp<0) {
                player2.takeCard(card2);
                player2.takeCard(card1);
            }else {
                ULStack<Card> warCards1 = new ULStack<>();
                ULStack<Card> warCards2 = new ULStack<>();

                while (battleComp==0){
                    // Each player plays 2 face-down card and a face-up card
                    for(int i = 0; i<CARDS_IN_WAR;++i){
                        warCards1.push(player1.playCard());
                        warCards2.push(player2.playCard());
                    }

                    userinterface.displayWar(CARDS_IN_WAR-1,warCards1.top(),CARDS_IN_WAR-1,warCards2.top());

                    // Determine the winner of the war
                    battleComp = warCards1.top().compareRanks(warCards2.top());

                    if(battleComp>0){
                        while(warCards1.size()!=0){
                            player1.takeCard(warCards1.pop());
                        }
                        player1.takeCard(card1);
                        while(warCards2.size()!=0){
                            player1.takeCard(warCards2.pop());
                        }
                        player1.takeCard(card2);
                    }
                    else if (battleComp<0) {
                        while(warCards2.size()!=0){
                            player2.takeCard(warCards2.pop());
                        }
                        player2.takeCard(card2);

                        while(warCards1.size()!=0){
                            player2.takeCard(warCards1.pop());
                        }
                        player2.takeCard(card1);
                    }
                }
            }
            userinterface.displayPostBattleScores(player1.cardsInHand(), player2.cardsInHand());
        }
        userinterface.displayGameOver(player1.cardsInHand(),player2.cardsInHand());
    }
}
