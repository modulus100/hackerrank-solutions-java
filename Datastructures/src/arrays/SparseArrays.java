package arrays;

import java.util.HashMap;
import java.util.function.Function;

public class SparseArrays {

    public static void main(String[] args) {

    }

    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] foo = new int[queries.length];
        HashMap<String, Integer> map = new HashMap<>();
        Function<String, Void> put = value -> {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
            return null;
        };

        for (String value : strings) {
            put.apply(value);
        }

        for (int i = 0; i < queries.length; i++) {
            foo[i] = map.getOrDefault(queries[i], 0);
        }

        return foo;
    }
}
