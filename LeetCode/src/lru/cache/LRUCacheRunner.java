package lru.cache;

public class LRUCacheRunner {
    public static void main(String[] args) {
        /*LRUCache cache = new LRUCache(5);

        int result = -1;

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);


        result = cache.get(1);      //# returns 1
        System.out.println(result);

        result = cache.get(2);      //# returns 2
        System.out.println(result);

        result = cache.get(9);      //# returns -1 because 9 is not present in the cache
        System.out.println(result);

        cache.put(5, 5);
        cache.put(6, 6);

        result = cache.get(3);               //# returns -1 because the cache reached it's
        System.out.println(result);          // capacity and 3 was the least recently used entry*/


        LRUCache cache = new LRUCache(2);
        int result = -1;

        result = cache.get(2);
        System.out.println(result);

        cache.put(1,1);
        cache.put(2,2);

        result = cache.get(1);
        System.out.println(result);

        cache.put(3,3);

        result = cache.get(2);
        System.out.println(result);

        cache.put(4,4);

        result = cache.get(1);
        System.out.println(result);

        result = cache.get(3);
        System.out.println(result);

        result = cache.get(4);
        System.out.println(result);

        /*LRUCache cache = new LRUCache(2);
        int result = -1;

        result = cache.get(2);
        System.out.println(result);

        result = cache.get(2);
        System.out.println(result);

        cache.put(2,6);

        result = cache.get(1);
        System.out.println(result);

        cache.put(1,5);
        cache.put(1,2);

        result = cache.get(1);
        System.out.println(result);

        result = cache.get(2);
        System.out.println(result);*/
    }
}
