package war;

import java.util.ArrayList;
public class Player {
    private  ULQueue<Card> hand;

    public Player() {
        hand = new ULQueue<>();
    }

    public void takeCard(Card aCard) {
        hand.push(aCard);
    }

    public Card playCard() {
        return hand.pop();
    }

    public int cardsInHand() {
        return hand.size();
    }
}
