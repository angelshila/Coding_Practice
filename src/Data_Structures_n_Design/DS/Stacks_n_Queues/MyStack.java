package Stacks_n_Queues;

import java.util.EmptyStackException;

public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
        public T getData(){
            return this.data;
        }
    }

    private StackNode<T> top;

    public void push(T data) {
        StackNode<T> node = new StackNode<>(data);
        node.next = top;
        top = node;
    }

    public T pop() {
        if (top == null)
            throw new EmptyStackException();
        T data = top.getData();
        top = top.next;
        return data;
    }

    public T peek() {
        if(top == null)
            throw new EmptyStackException();
        return top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

}
