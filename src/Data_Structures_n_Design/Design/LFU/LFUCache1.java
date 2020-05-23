package LFU;

import java.util.HashMap;
import java.util.Map;

public class LFUCache1 {

    class Node {
        int key;
        int value;
        int frequency;
        Node pre;
        Node next;
        NodeQueue nq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 0;
        }
    }

    class NodeQueue {
        NodeQueue pre;
        NodeQueue next;
        Node head;
        Node tail;

        NodeQueue(NodeQueue pre, NodeQueue next, Node head, Node tail) {
            this.pre = pre;
            this.next = next;
            this.head = head;
            this.tail = tail;
        }
    }

    int capacity;
    NodeQueue head;
    Map<Integer, Node> map;

    private void removeNode(Node n) {
        if(n.nq.tail == n.nq.head) {
            removeNQ(n.nq);
            return;
        }

        if(n.next!=null) n.next.pre = n.pre;
        if(n.pre!=null) n.pre.next = n.next;
        if(n.nq.head==n) n.nq.head = n.next;
        if(n.nq.tail==n) n.nq.tail = n.pre;
        n.next = null;
        n.pre = null;
    }

    private void removeNQ(NodeQueue nq) {
        if(nq.next!=null) nq.next.pre = nq.pre;
        if(nq.pre!=null) nq.pre.next = nq.next;
        if(this.head == nq) this.head=nq.next;
    }

    private void setNode(Node n) {
        n.frequency++;
        boolean singleNode = false;
        if(n.nq.head==n.nq.tail) {
            singleNode = true;
        }
        if(n.nq.next!=null) {
            if(n.nq.next.head.frequency==n.frequency) {
                removeNode(n);
                n.nq.next.tail.next = n;
                n.pre = n.nq.next.tail;
                n.nq.next.tail = n;
                n.nq = n.nq.next;
            }
            else if(n.nq.next.head.frequency>n.frequency) {
                if(!singleNode) {
                    removeNode(n);
                    NodeQueue nnq = new NodeQueue(n.nq, n.nq.next, n, n);
                    n.nq.next.pre = nnq;
                    n.nq.next = nnq;
                    n.nq = nnq;
                }
            }
        }
        else {
            if(!singleNode){
                removeNode(n);
                NodeQueue nnq = new NodeQueue(n.nq, null, n, n);
                n.nq.next = nnq;
                n.nq = nnq;
            }
        }
    }

    public LFUCache1(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        Node n = map.get(key);
        if(n==null) return -1;
        setNode(n);
        return n.value;
    }

    public void put(int key, int value) {
        if (capacity==0) return;
        Node node = map.get(key);
        if(node!=null) {
            node.value = value;
            setNode(node);
            return;
        }

        if(map.size() == capacity) {
            map.remove(this.head.head.key);
            removeNode(this.head.head);
        }

        Node n = new Node(key, value);
        if(this.head != null) {
            if(this.head.head.frequency>0) {
                NodeQueue nq = new NodeQueue(null, this.head, n, n);
                this.head.pre = nq;
                this.head = nq;
                n.nq = nq;
            }
            else {
                n.nq = this.head;
                this.head.tail.next = n;
                n.pre = this.head.tail;
                this.head.tail = n;
            }
        }
        else {
            NodeQueue nq = new NodeQueue(null, null, n, n);
            this.head = nq;
            n.nq = nq;
        }
        map.put(key, n);
    }
}