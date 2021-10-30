package lru.cache;

import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {
    private final HashMap<Integer, Integer> cache;
    private final HashMap<Integer, Integer> countMap;
    private final LinkedList<Integer> queue;
    private final int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap();
        this.queue = new LinkedList();
        this.countMap = new HashMap();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (countMap.containsKey(key)) {
            int count = countMap.get(key);
            countMap.put(key, ++count);
        }

        if (cache.containsKey(key)) {
            queue.addFirst(key);

            if (queue.size() > capacity) {
                int deleted = queue.pollLast();

                if (countMap.containsKey(deleted)) {
                    int count = countMap.get(deleted);

                    if (count == 1) {
                        countMap.remove(deleted);
                        cache.remove(deleted);
                    } else {
                        cache.put(deleted, --count);
                    }
                }
            }

            return cache.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            return;
        }

        cache.put(key, value);
        queue.addFirst(key);
        countMap.put(key, 1);

        if (queue.size() > capacity) {
            int deleted =  queue.pollLast();

            if (countMap.containsKey(deleted)) {
                int count = countMap.get(deleted);

                if (count == 1) {
                    countMap.remove(deleted);
                    cache.remove(deleted);
                } else {
                    cache.put(deleted, --count);
                }
            }
        }
    }
}
