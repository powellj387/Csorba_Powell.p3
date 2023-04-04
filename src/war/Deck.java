package war;

public class Deck {
    private int size;
    private ULStack<Card> cards;
    private Card.Suit[] orderedSuits = {};
    private Card.Rank[] orderedRanks = {};
    public Deck(){
        cards = new ULStack<>(52);
        for(Card.Suit suit: Card.Suit.values()){
            for(Card.Rank rank: Card.Rank.values()){
                cards.add()
            }
        }
    }

    public void shuffle(java.util.Random prng){

    }

    public Card dealCard(){

    }

    public int size(){
        return size;
    }

    public boolean empty(){
        return size==0;
    }
}
