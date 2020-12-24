package dictionaries.and.hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyQueries {

    public static void main(String[] args) {

    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (List<Integer> query : queries) {
            int action = query.get(0);
            int value = query.get(1);

            if (action == 1) {
                if (map.containsKey(value)) {
                    int oldCount = map.get(value);
                    int newCount = oldCount + 1;

                    map.put(value, newCount);

                    decrementFreqCount(freqMap, oldCount);
                    incrementFreqCount(freqMap, newCount);
                } else {
                    map.put(value, 1);
                    incrementFreqCount(freqMap, 1);
                }
            } else if (action == 2) {
                if (map.containsKey(value)) {
                    int oldCount = map.get(value);
                    int newCount = oldCount - 1;

                    if (newCount == 0) {
                        map.remove(value);
                    } else {
                        map.put(value, newCount);
                        incrementFreqCount(freqMap, newCount);
                    }

                    decrementFreqCount(freqMap, oldCount);
                }
            } else if (action == 3) {
                if (freqMap.containsKey(value)) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            }
        }

        return result;
    }

    static void incrementFreqCount(HashMap<Integer, Integer> map, int value) {
        if (map.containsKey(value)) {
            map.put(value, map.get(value) + 1);
        } else {
            map.put(value, 1);
        }
    }

    static void decrementFreqCount(HashMap<Integer, Integer> map, int value) {
        if (map.containsKey(value)) {
            int count = map.get(value);

            if (count > 1) {
                map.put(value, count - 1);
            } else if (count == 1) {
                map.remove(value);
            }
        }
    }
}
