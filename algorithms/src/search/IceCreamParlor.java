package search;

import java.util.HashMap;

public class IceCreamParlor {

    static int[] icecreamParlor(int m, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] empty = {};

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                return new int[] {map.get(arr[i]) + 1, i + 1};
            } else if (m > arr[i]) {
                map.put(m - arr[i], i);
            }
        }

        return empty;
    }
}
