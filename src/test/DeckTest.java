package test;

import org.junit.jupiter.api.Test;
import war.*;
import java.util.Random;
import java.util.Stack;


public class DeckTest {
    @Test
    public void testUnshuffled() {
        Stack<Card> testDeck = new Stack<>();

        testDeck.push(new Card(Card.Rank.ACE, Card.Suit.SPADES));
        testDeck.push(new Card(Card.Rank.KING, Card.Suit.SPADES));
        testDeck.push(new Card(Card.Rank.QUEEN, Card.Suit.SPADES));
        testDeck.push(new Card(Card.Rank.JACK, Card.Suit.SPADES));
        testDeck.push(new Card(Card.Rank.TEN, Card.Suit.SPADES));
        testDeck.push(new Card(Card.Rank.NINE, Card.Suit.SPADES));
        testDeck.push(new Card(Card.Rank.EIGHT, Card.Suit.SPADES));
        testDeck.push(new Card(Card.Rank.SEVEN, Card.Suit.SPADES));
        testDeck.push(new Card(Card.Rank.SIX, Card.Suit.SPADES));
        testDeck.push(new Card(Card.Rank.FIVE, Card.Suit.SPADES));
        testDeck.push(new Card(Card.Rank.FOUR, Card.Suit.SPADES));
        testDeck.push(new Card(Card.Rank.THREE, Card.Suit.SPADES));
        testDeck.push(new Card(Card.Rank.TWO, Card.Suit.SPADES));

        testDeck.push(new Card(Card.Rank.ACE, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.KING, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.QUEEN, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.JACK, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.TEN, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.NINE, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.EIGHT, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.SEVEN, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.SIX, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.FIVE, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.FOUR, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.THREE, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.TWO, Card.Suit.DIAMONDS));

        testDeck.push(new Card(Card.Rank.ACE, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.KING, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.QUEEN, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.JACK, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.TEN, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.NINE, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.EIGHT, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.SEVEN, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.SIX, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.FIVE, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.FOUR, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.THREE, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.TWO, Card.Suit.CLUBS));

        testDeck.push(new Card(Card.Rank.ACE, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.KING, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.QUEEN, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.JACK, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.TEN, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.NINE, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.EIGHT, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.SEVEN, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.SIX, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.FIVE, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.FOUR, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.THREE, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.TWO, Card.Suit.HEARTS));

        Deck deck = new Deck();

        for(int i=0; i<52; ++i){
            assert testDeck.pop().equals(deck.dealCard());
        }
    }


    @Test

    public void shuffleTest(){
        Stack<Card> testDeck = new Stack<>();

        testDeck.push(new Card(Card.Rank.FIVE, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.EIGHT, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.THREE, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.SEVEN, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.JACK, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.JACK, Card.Suit.HEARTS));
        testDeck.push(new Card(Card.Rank.SIX, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.FIVE, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.EIGHT, Card.Suit.DIAMONDS));
        testDeck.push(new Card(Card.Rank.SEVEN, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.FIVE, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.QUEEN, Card.Suit.CLUBS));
        testDeck.push(new Card(Card.Rank.EIGHT, Card.Suit.CLUBS));

        Deck deck = new Deck();
        Random rand = new Random(2);
        deck.shuffle(rand);

        for(int i=0; i<13; ++i){
            assert testDeck.pop().equals(deck.dealCard());
        }
    }
}
