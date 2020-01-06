package hackerrank;

import java.util.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        TreeSet<Integer> sortedContainer = new TreeSet<>();
        HashMap<Integer, Integer> counterMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        int counter = 0;

        for (int i = 0; i < expenditure.length; i++) {
            if (i >= d) {
                List<Integer> sortedList = convertToList(sortedContainer, counterMap);
                double median = getMedian(sortedList);

                if (expenditure[i] >= median * 2) {
                    counter++;
                }

                int firstElement = queue.poll();
                removeValue(sortedContainer, counterMap, firstElement);

            }

            queue.add(expenditure[i]);
            addValue(sortedContainer, counterMap, expenditure[i]);
        }

        return counter;
    }

    public static void addValue(TreeSet<Integer> sortedContainer, HashMap<Integer, Integer> counterMap, int value) {
        if (counterMap.containsKey(value)) {
            int valueCounter = counterMap.get(value);
            valueCounter++;
            counterMap.put(value, valueCounter);
        } else {
            counterMap.put(value, 1);
            sortedContainer.add(value);
        }
    }

    public static void removeValue(TreeSet<Integer> sortedContainer, HashMap<Integer, Integer> counterMap, int value) {
        if (!counterMap.containsKey(value)) { return; }

        int valueCounter = counterMap.get(value);
        valueCounter--;

        if (valueCounter == 0) {
            counterMap.remove(value);
            sortedContainer.remove(value);
        }
    }

    public static List<Integer> convertToList(TreeSet<Integer> sortedContainer, HashMap<Integer, Integer> counterMap) {
        List<Integer> list = new ArrayList<>();

        for (int containerValue : sortedContainer) {
            int valueCounter = counterMap.get(containerValue);

            while (valueCounter-- != 0) {
                list.add(containerValue);
            }
        }

        return list;
    }

    public static double getMedian(List<Integer> sortedList) {
        int center = sortedList.size() / 2;

        if (center % 2 == 0) {
            return (double)(sortedList.get(center - 1) + sortedList.get(center)) / 2;
        } else {
            return sortedList.get(center);
        }
    }

    public static void main(String[] args)  {
        int expenditure[] = {2, 3, 4, 2, 3, 6, 8, 4, 5, 2, 3, 4, 2, 3, 6, 8, 4, 5};
        int result = activityNotifications(expenditure, 5);

        System.out.println(result);
    }
}
