package LRU;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LRUCache2 {

    HashMap<Integer,Integer> cache;
    int capacity;
    LinkedHashSet<Integer> leastRecentKeys;

    public LRUCache2(int capacity) {
        cache = new HashMap();
        this.capacity = capacity;
        leastRecentKeys = new LinkedHashSet();
    }

    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        int value = cache.get(key);
        moveToHead(key);
        return value;
    }

    public void put(int key, int value) {

        if(cache.containsKey(key)) {
            cache.put(key,value);
            moveToHead(key);
        }else {
            addToHead(key);
            cache.put(key,value);
        }

        if (cache.size() > this.capacity) {
            popTail();
        }
    }

    public void moveToHead(int key) {
        removeKeyFromList(key);
        addToHead(key);
    }

    public void removeKeyFromList(int key) {
        leastRecentKeys.remove(key);
    }

    public void addToHead(int key) {
        leastRecentKeys.add(key);
    }

    public void popTail() {
        int lru = leastRecentKeys.iterator().next();
        removeKeyFromList(lru);
        cache.remove(lru);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */