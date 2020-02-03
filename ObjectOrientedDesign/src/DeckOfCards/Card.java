package DeckOfCards;

public class Card {

    private final FaceValue faceValue;
    private final Suit suit;

    public Card(FaceValue v, Suit s) {
        this.faceValue = v;
        this.suit = s;
    }

    public FaceValue value() {
        return faceValue;
    }

    public Suit suit() {
        return suit;
    }
}
