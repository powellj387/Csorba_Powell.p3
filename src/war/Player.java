package war;

import java.util.ArrayList;
public class Player {
    private ArrayList<Card> hand;

    public Player() {
        hand = new ArrayList<Card>();
    }

    public void takeCard(Card aCard) {
        hand.add(aCard);
    }

    public Card playCard() {
        return hand.remove(0);
    }

    public int cardsInHand() {
        return hand.size();
    }
}
