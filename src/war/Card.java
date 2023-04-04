//@authors Julian Powell and Alex Csorba
package war;
public class Card{
    public enum Rank
    {
        TWO("2"),THREE("3"),TEN("T"),SIX("6"),SEVEN("7"),
        QUEEN("Q"),NO_RANK(""),NINE("9"),KING("K"),
        JACK("J"),FOUR("4"),FIVE("5"),EIGHT("8"),ACE("A");

        private String abbreviation;

        Rank(String abbrev) {abbreviation = abbrev;}

        public String getAbbreviation()
        {
            return abbreviation;
        }


    }

    public enum Suit
    {
        SPADES("S"),NO_SUIT(""),HEARTS("H"),DIAMONDS("D"),CLUBS("C");

        private String abbreviation;

        Suit(String abbrev) {abbreviation = abbrev;}

        public String getAbbreviation()
        {
            return abbreviation;
        }
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

    public java.lang.String toString(){return cardRank.getAbbreviation()+cardSuit.getAbbreviation();}

    public boolean equals(Card cardToCheck) {return cardRank==cardToCheck.getRank()&&cardSuit==cardToCheck.getSuit();}

    public int compareRanks(Card otherCard){return cardRank.compareTo(otherCard.getRank());}
}
