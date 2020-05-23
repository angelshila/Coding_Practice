package Q1_Three_in_One;

import java.util.EmptyStackException;

public class FixedMultiStack {

    int capacity;
    int[] values;
    int[] sizes;

    public FixedMultiStack (int capacity, int stackCount) {
        this.capacity = capacity;
        this.values = new int[stackCount * this.capacity];
        this.sizes = new int[stackCount];
    }

    // Push
    // Pop
    // Peek
    // isEmpty

    public void push(int stackNum, int data) throws FullStackException {
        // Check if that stack has capacity
        if(isFull(stackNum)) {
            throw new FullStackException();
        }
        // Increment Size
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = data;
    }

    public int pop(int stackNum) {
        if(isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int val = values[topIndex];
        // Clear value
        values[topIndex] = 0;
        sizes[stackNum]--;
        return val;
    }

    /* Return top element. */
    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * capacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] == capacity;
    }
}

class FullStackException extends Exception {
    private static final long serialVersionUID = 1L;

    public FullStackException(){
        super();
    }

    public FullStackException(String message){
        super(message);
    }
}
