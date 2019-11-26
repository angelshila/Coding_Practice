package Stacks_n_Queues;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode next;

        public QueueNode(T data){
            this.data = data;
        }

        public T getData (){
            return this.data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T data){
        QueueNode<T> node = new QueueNode<>(data);
        if(last!=null){
            last.next = node;
        }
        last = node;
        if(first == null){
            first = last;
        }
    }

    public T remove(){
        if(first == null)
            throw new NoSuchElementException();
        T data = first.getData();
        first = first.next;
        if(first == null){
            last = null;
        }
        return data;
    }

    public T peek(){
        if(first == null)
            throw new NoSuchElementException();
        return first.getData();
    }

    public boolean isEmpty(){
        return first == null;
    }

}
