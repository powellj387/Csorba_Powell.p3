package war;

import java.util.*;

public class Deck {
    private final ULStack<Card> cards;

    private Card.Suit[] orderedSuits = {Card.Suit.HEARTS, Card.Suit.CLUBS, Card.Suit.DIAMONDS, Card.Suit.SPADES};

    private Card.Rank[] orderedRanks = {Card.Rank.KING,Card.Rank.QUEEN, Card.Rank.JACK, Card.Rank.TEN,
            Card.Rank.NINE, Card.Rank.EIGHT, Card.Rank.SEVEN, Card.Rank.SIX, Card.Rank.FIVE, Card.Rank.FOUR,
            Card.Rank.THREE, Card.Rank.TWO,Card.Rank.ACE};

    public Deck(){
        cards = new ULStack<>();
        for(Card.Suit suit: orderedSuits){
            for(Card.Rank rank: orderedRanks){
                Card newCard = new Card(rank, suit);
                cards.push(newCard);
            }
        }
    }

    public void shuffle(java.util.Random prng) {
        List<Card> cardList = new ArrayList<>();

        while(!cards.empty()){
            cardList.add(cards.pop());
        }
        Collections.reverse(cardList);

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
