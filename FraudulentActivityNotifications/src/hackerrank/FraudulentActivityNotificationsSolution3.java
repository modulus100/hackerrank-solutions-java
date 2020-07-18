package hackerrank;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Function;

public class FraudulentActivityNotificationsSolution3 {

    public static void main(String[] args) {
        //int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5, 9};
        int[] expenditure = {10, 20, 30, 40, 50};
        int result = activityNotifications(expenditure, 3);
    }

    static int activityNotifications(int[] expenditure, int d) {
        Deque<Integer> buffer = new LinkedList<>();
        int notificationCount = 0;

        for (int value : expenditure) {
            if (buffer.size() == d) {
                double median = getMedian(toIntArray(buffer));

                if (fraudCondition(median, value)) {
                    notificationCount++;
                }

                buffer.removeFirst();
            }

            buffer.add(value);
        }

        return notificationCount;
    }

    static boolean fraudCondition(double median, int value) {
        return (double) value >= median * 2 ;
    }

    static double getMedian(int[] buffer) {
        if (buffer.length == 0) return 0;
        int center = buffer.length / 2;
        int[] sortedBuffer = countingSort(buffer);
        Function<Integer, Boolean> isEven = (Integer i) -> i % 2 == 0;

        return isEven.apply(sortedBuffer.length)
                ? (double) (sortedBuffer[center] + sortedBuffer[center - 1]) / 2
                : sortedBuffer[center];
    }

    static int[] countingSort(int[] buffer) {
        int[] sortedBuffer = new int[buffer.length];
        int[] countArr = new int[201];

        for (int value : buffer) {
            countArr[value]++;
        }

        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }

        for (int value : buffer) {
            int index = countArr[value] - 1;
            sortedBuffer[index] = value;
            countArr[value]--;
        }

        return sortedBuffer;
    }

    static int [] toIntArray(Deque<Integer> buffer) {
        int[] intArr = new int[buffer.size()];
        int i = 0;

        for (int value : buffer) {
            intArr[i++] = value;
        }

        return intArr;
    }
}
