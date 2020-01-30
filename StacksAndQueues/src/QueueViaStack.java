import java.util.Deque;
import java.util.LinkedList;

public class QueueViaStack {

    // Implement a MyQueue class which implements a queue using two stacks

    Deque<Integer> s1;
    Deque<Integer> s2;

    public QueueViaStack() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    // size
    public int size() {
        return s1.size() + s2.size();
    }

    // add
    public void add(int val) {
        s1.offerFirst(val);
    }

    // remove
    public Integer remove() {
        if (s2.isEmpty()) {
            shiftStack();
        }
        return s2.pollFirst();
    }

    // peek
    public Integer peek() {
        if (s2.isEmpty()) {
            shiftStack();
        }
        return s2.peekFirst();
    }

    // shift
    private void shiftStack() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.offerFirst(s1.pollFirst());
            }
        }
    }

}
