import java.util.Deque;
import java.util.LinkedList;

public class StackMin {

    private Deque<Integer> stack;
    private Deque<Integer> min;

    public StackMin() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public int min() {
        if (min.isEmpty()) {
            return -1;
        }
        return min.peekFirst();
    }

    public void push(int value) {
        stack.offerFirst(value);
        if (min.isEmpty() || value <= min.peekFirst()) {
            min.offerFirst(value);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        Integer res = stack.pollFirst();
        if (min.peekFirst().equals(res)) {
            min.pollFirst();
        }
        return res;
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peekFirst();
    }
}
