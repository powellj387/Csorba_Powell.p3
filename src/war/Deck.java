//@authors Alex Csorba and Julian Powell
package war;

import java.util.*;

public class Deck {
    private final ULStack<Card> cards;

    private Card.Suit[] orderedSuits = {Card.Suit.SPADES,Card.Suit.DIAMONDS,Card.Suit.CLUBS,Card.Suit.HEARTS};

    private Card.Rank[] orderedRanks = {Card.Rank.ACE,Card.Rank.KING,Card.Rank.QUEEN, Card.Rank.JACK, Card.Rank.TEN,
            Card.Rank.NINE, Card.Rank.EIGHT, Card.Rank.SEVEN, Card.Rank.SIX, Card.Rank.FIVE, Card.Rank.FOUR,
            Card.Rank.THREE, Card.Rank.TWO};

    public Deck(){
        cards = new ULStack<>();
        //
        for(Card.Suit suit: orderedSuits){
            for(Card.Rank rank: orderedRanks){
                cards.push(new Card(rank, suit));
            }
        }
    }

    public void shuffle(java.util.Random prng) {
        List<Card> cardList = new ArrayList<>();

        while(!cards.empty()) {
            cardList.add(cards.pop());
        }

        for (int i = 0; i < 7; i++) {
            Collections.shuffle(cardList, prng);
        }

        Collections.reverse(cardList);
        for (Card card : cardList) {
            cards.push(card);
        }
    }

    public Card dealCard(){
        return cards.pop();
    }

    public int size(){
        return cards.size();
    }

    public boolean empty(){
        return cards.size()==0;
    }
}
