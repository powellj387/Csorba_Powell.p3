//@authors Julian Powell and Alex Csorba
package war;
public class Card{
    public enum Rank
    {
        ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING
    }

    public enum Suit
    {
        CLUBS,DIAMONDS,HEARTS,SPADES
    }

    final int CARDS_PER_DECK = 52;
    Card.Rank cardRank;
    Card.Suit cardSuit;

    public void Card()
    {
    }

    public Card(Card.Rank aRank, Card.Suit aSuit)
    {
        cardRank = aRank;
        cardSuit = aSuit;
    }

    public Card.Suit getSuit()
    {
        return cardSuit;
    }

    public Card.Rank getRank()
    {
        return cardRank;
    }

    public boolean equals(Card cardToCheck) {return cardRank==cardToCheck.getRank()&&cardSuit==cardToCheck.getSuit();}

    public int compareRanks(Card otherCard){return cardRank.compareTo(otherCard.getRank());}
}
