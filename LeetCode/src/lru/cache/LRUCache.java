package lru.cache;

import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {
    private HashMap<Integer, Integer> cache;
    private HashMap<Integer, Integer> countMap;
    private LinkedList<Integer> queue;
    private int capacity;

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


    /*public int get(int key) {
        if (cache.containsKey(key)) {
            int count = countMap.get(key);
            countMap.put(key, ++count);
            queue.addFirst(key);
            updateCacheQueue();
            return cache.get(key);
        } else {
            //countMap.put(key, 1);
            //queue.addFirst(key);
            //updateCacheQueue();
            return -1;
        }
    }

    public void put(int key, int value) {
        cache.put(key, value);

        if (countMap.containsKey(key)) {
            int count = countMap.get(key);
            countMap.put(key, ++count);
        } else {
            countMap.put(key, 1);
            queue.addFirst(key);
        }

        updateCacheQueue();
    }

    private void updateCacheQueue() {
        if (queue.size() > capacity) {
            int last = queue.pollLast();

            if (countMap.containsKey(last) && cache.containsKey(last)) {
                int count = countMap.get(last);

                if (count == 1) {
                    countMap.remove(last);
                    cache.remove(last);
                } else {
                    countMap.put(last, --count);
                }
            }
        }
    }*/
}
