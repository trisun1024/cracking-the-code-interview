import java.util.Deque;
import java.util.LinkedList;

public class SortStack {

    // Write a program to sort a stack such that smallest items are on the top. You can use an additional
    // temporary stack, but you may not copy the elements into another data structure. The stack supports
    // the following operations: push, pop, peek, and isEmpty.

    public void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()) {
            int tmp = s.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }

    static class Stack<T> {
        Deque<T> s;

        Stack() {
            s = new LinkedList<>();
        }

        void push(T val) {
            s.offerFirst(val);
        }

        T pop() {
            return s.pollFirst();
        }

        T peek() {
            return s.peekFirst();
        }

        boolean isEmpty() {
            return s.isEmpty();
        }
    }
}
