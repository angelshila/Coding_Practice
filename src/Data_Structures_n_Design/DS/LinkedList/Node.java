package LinkedList;

public class Node {

    Object val;
    Node next;

    public Node() {
        this.val = 0;
        this.next = null;
    }

    public Node(Object v){
        this.val = v;
        this.next = null;
    }

    public void setData(Object val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData(){
        return val;
    }

    public Node getNext(){
        return next;
    }

}