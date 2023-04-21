//@authors Alex Csorba and Julian Powell
package war;
import static java.lang.System.out;

import java.util.Random;


/**
 * This class is used to test your project for Milestone 1.
 * @author Joe Meehean
 *
 */

public class MS1Main {
	
	public static void main(String[] args) {
		//testUnshuffled();
		testShuffled(2);
	}
	

/**
	 * Prints out the contents of an unshuffled deck
	 */

	public static void testUnshuffled() {
		Deck deck = new Deck();
		while( deck.size() != 0 ) {
			out.println(deck.dealCard());
		}
	}

/**
	 * Prints out the contents of a deck shuffled with the given seed.
	 * @param seed
	 */

	public static void testShuffled(int seed) {
		Deck deck = new Deck();
		deck.shuffle( new Random(seed) );
		while( deck.size() != 0 ) {
			out.println(deck.dealCard());
		}
	}
}

