package CallCenter;

public enum Rank {

    Responder(0), Director(1), Manager(2);

    private int value;

    Rank(int v) {
        value = v;
    }
}
