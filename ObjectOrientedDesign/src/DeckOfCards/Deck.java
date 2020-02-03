package DeckOfCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private static final Random rand = new Random();
    private final List<Card> cards = new ArrayList<>();
    private int dealtIndex = 0;

    public Deck() {
        for (FaceValue v : FaceValue.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(v, suit));
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i < cards.size() - 1; i++) {
            int j = rand.nextInt(cards.size() - i) + i;
            Card c1 = cards.get(i);
            Card c2 = cards.get(j);
            cards.set(i, c2);
            cards.set(j, c1);
        }
    }

    public int remainingCards() {
        return cards.size() - dealtIndex;
    }

    public Card[] dealHand(int number) {
        if (remainingCards() < number) {
            return null;
        }
        Card[] cards = new Card[number];
        for (int i = 0; i < number; i++) {
            cards[i] = dealCard();
        }
        return cards;
    }

    public Card dealCard() {
        return remainingCards() == 0 ? null : cards.get(dealtIndex++);
    }

}
