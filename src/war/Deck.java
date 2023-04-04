package war;

public class Deck {
    private int size;
    private ULStack<Card> cards;
private Card.Suit[] orderedSuits = {Card.Suit.HEARTS, Card.Suit.CLUBS, Card.Suit.DIAMONDS, Card.Suit.SPADES};
    private Card.Rank[] orderedRanks = {Card.Rank.KING, Card.Rank.QUEEN, Card.Rank.JACK, Card.Rank.TEN,
            Card.Rank.NINE, Card.Rank.EIGHT, Card.Rank.SEVEN, Card.Rank.SIX, Card.Rank.FIVE, Card.Rank.FOUR,
            Card.Rank.THREE, Card.Rank.TWO, Card.Rank.ACE};
    public Deck(){

        cards = new ULStack<Card>();
        for(Card.Suit suit: orderedSuits){
            for(Card.Rank rank: orderedRanks){
                Card newCard = new Card(rank, suit);
                cards.push(newCard);
            }
        }
    }

    public void shuffle(java.util.Random prng){

    }

    public Card dealCard(){
        return cards.pop();
    }

    public int size(){
        return cards.size();
    }

    public boolean empty(){
        return size==0;
    }
}
