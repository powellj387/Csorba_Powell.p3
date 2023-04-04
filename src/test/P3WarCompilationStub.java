/*
package test;

import java.util.Random;

import war.Card;
import war.ConsoleInterface;
import war.Deck;
import war.Player;
import war.War;

*/
/**
 * This class is designed to help you test whether your War program code will compile in my JUnit tests.
 * Be sure that you can compile this class, unmodified.  
 * If your code does not compile with this class, I will not be able to test your code.
 * If your code does compile with this class, odds are good it will compile in my JUnit tests.
 * Your code compiling with this class is not a sufficient level of testing.
 * @author Joe Meehean
 *
 *//*

public class P3WarCompilationStub {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Deck
		Deck deck = new Deck();
		Card card = deck.dealCard();
		boolean bool = deck.empty();
		deck.shuffle(new Random(2));
		int size = deck.size();
		
		// Player
		Player player = new Player();
		player.takeCard(card);
		card = player.playCard();
		int cardCount = player.cardsInHand();
		
		// ConsoleInterface
		ConsoleInterface ci = new ConsoleInterface(System.out);
		ci.newGame();
		ci.displayPostBattleScores(10, 15);
		ci.displaySingleCardBattle(card, card);
		ci.displayWar(1, card, 2, card);
		ci.displayGameOver(52, 0);

		
		// War
		War war = new War(7, new ConsoleInterface(System.out));
		war.playGame();
		war.testPlayGame(player, player);
	}
}
*/
