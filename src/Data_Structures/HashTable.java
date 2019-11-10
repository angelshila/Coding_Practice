package Data_Structures;

import java.util.ArrayList;
import java.util.Hashtable;

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

    private static ArrayList<HashNode> keyList = new ArrayList<>();
    private static int size = 0;
    private static int capacity = 10;

    public HashTable () {
        for (int i = 0; i < capacity; i++)
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
        int index = hashCode % capacity;
        return index;
    }

    public static String get (String key) {
        int index = getIndex(key);
        HashNode head = keyList.get(index);
        while (head != null) {

            if (head.key == key) {
                return head.key+" "+head.value;
            }
            head = head.next;
        }
        return null;
    }

    public static void add (String key, Integer value) {

        int index = getIndex(key);
        HashNode head = keyList.get(index);
        while (head != null) {
            if (head.key == key) {
                System.out.println("Key exists. Value will be updated.");
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = keyList.get(index);
        HashNode newNode = new HashNode(key,value);
        newNode.next = head;
        keyList.set(index,newNode);
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
        System.out.println(map.get("anu"));
        map.add("anu",1 );
        map.add("shila",6 );
        map.add("teddy",8 );
        map.add("pizza",1 );
        map.add("pizza",3 );
        System.out.println(map.get("anu"));
        System.out.println(map.get("pizza"));
        System.out.println(map.size());
        System.out.println(map.remove("anu"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
