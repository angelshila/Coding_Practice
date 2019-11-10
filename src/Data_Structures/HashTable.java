package Data_Structures;

import java.util.ArrayList;

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
        System.out.println(keyList);
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
        map.add("anu",1 );
        map.add("shila",6 );
        map.add("teddy",8 );
        map.add("pizza",1 );
        System.out.println(map.keyList);
        System.out.println(map.size());
        System.out.println(map.remove("anu"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
