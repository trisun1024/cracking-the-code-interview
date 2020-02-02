import java.util.ArrayList;
import java.util.List;

public class FlipBitToWin {

    // You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to find the length
    // of the longest sequence of 1s you could create.

    // Brute Force
    public int longestSequence(int n) {
        if (n == -1) {
            return Integer.BYTES * 8;
        }
        List<Integer> sequences = getAlternatingSequences(n);
        return findLongestSequence(sequences);
    }

    private List<Integer> getAlternatingSequences(int n) {
        List<Integer> sequences = new ArrayList<>();
        int search = 0;
        int counter = 0;
        for (int i = 0; i < Integer.BYTES * 8; i++) {
            if ((n & 1) != search) {
                sequences.add(counter);
                search = n & 1;
                counter = 0;
            }
            counter++;
            n >>>= 1;
        }
        sequences.add(counter);
        return sequences;
    }

    private int findLongestSequence(List<Integer> seq) {
        int max = 1;
        for (int i = 0; i < seq.size(); i += 2) {
            int zero = seq.get(i);
            int onePrev = i - 1 >= 0 ? seq.get(i - 1) : 0;
            int oneNext = i + 1 < seq.size() ? seq.get(i + 1) : 0;
            int thisSeq = 0;
            if (zero == 1) {
                thisSeq = oneNext + 1 + onePrev;
            } else if (zero > 1) {
                thisSeq = 1 + Math.max(onePrev, oneNext);
            } else if (zero == 0) {
                thisSeq = Math.max(onePrev, oneNext);
            }
            max = Math.max(thisSeq, max);
        }
        return max;
    }

    // Optimal Algorithm
    public int flipBit(int a) {
        if (~a == 0) {
            return Integer.BYTES * 8;
        }
        int cur = 0;
        int prev = 0;
        int max = 1;
        while (a != 0) {
            if ((a & 1) == 1) {
                cur++;
            } else if ((a & 1) == 0) {
                prev = (a & 2) == 0 ? 0 : cur;
                cur = 0;
            }
            max = Math.max(prev + cur + 1, max);
            a >>>= 1;
        }
        return max;
    }
}
