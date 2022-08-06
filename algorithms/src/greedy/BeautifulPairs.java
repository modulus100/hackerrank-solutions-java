package greedy;

import java.util.HashMap;

public class BeautifulPairs {

    public static void main(String[] arg) {

    }

    static int beautifulPairs(int[] A, int[] B) {
        HashMap<Integer, Integer> mapCount = new HashMap<>();

        // freq table for A
        int count = 0;
        for (int aValue : A) {
            if (mapCount.containsKey(aValue)) {
                mapCount.put(aValue, mapCount.get(aValue) + 1);
            } else {
                mapCount.put(aValue, 1);
            }
        }

        for (int bValue : B) {
            if (mapCount.containsKey(bValue) && mapCount.get(bValue) > 0) {
                mapCount.put(bValue, mapCount.get(bValue) - 1);
                count++;
            }
        }

        return count == B.length ? B.length - 1 : B.length + 1;
    }
}
