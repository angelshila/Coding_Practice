package Q5_Sort_Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class SortStack {

    public static void sort(Deque<Integer> s) {
        Deque<Integer> buffer = new ArrayDeque();

        while (!s.isEmpty()) {
            int top = s.pop();
            while (!buffer.isEmpty() && buffer.peek() > top) {
                s.push(buffer.pop());
            }
            buffer.push(top);
        }

        while (!buffer.isEmpty()) {
            s.push(buffer.pop());
        }

    }

}
