package Data_Structures;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.ListIterator;

class HashNode {
    String key;
    Integer value;
    HashNode next;

    public HashNode (String key, Integer value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

}

public class HashTable {

    // ArrayList of LinkedLists

    private static ArrayList<HashNode> keyList = new ArrayList<>();
    private static int size = 0;
    private static int numBuckets = 10;

    public HashTable () {
        for (int i = 0; i < numBuckets; i++)
            keyList.add(null);
    }

    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static int getIndex(String key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index;
    }

    public static void add (String key, Integer value) {

        int index = getIndex(key);
       // System.out.println(index);
        HashNode head = keyList.get(index);

        if (head ==  null) {
            size++;
            keyList.add(index, new HashNode(key,value));
        } else {
            while (head.next != null) {
                if (head.value == value) {
                    System.out.println("Value exists");
                    return;
                }
                head = head.next;
            }
            size++;
            head.next = new HashNode(key,value);
        }
    }

    public static String remove(String key) {
        int index = getIndex(key);
        // System.out.println(index);
        HashNode head = keyList.get(index);

        if (head == null) {
            return null;
        }

        HashNode prev = null;
        while (head != null) {

            if (head.key.equals(key))
                break;
            prev = head;
            head = head.next;
        }

        if (prev != null)
            prev.next = head.next;
        else
            keyList.set(index,head.next);

        return head.key+" "+head.value;

    }

    public static void main(String[] args)
    {
        HashTable map = new HashTable();
        map.add("this",1 );
        map.add("coder",2 );
        map.add("this",4 );
        map.add("hi",5 );
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        Hashtable hm = new Hashtable();
    }
}
