package test;

import org.junit.jupiter.api.Test;
import war.*;
import java.util.Random;
import java.util.Stack;


public class CardTest {
    @Test
    public void testCardConst{
        Card testCard = new Card(Card.Rank.TWO, Card.Suit.DIAMONDS);
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
