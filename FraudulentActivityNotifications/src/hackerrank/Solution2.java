package hackerrank;

import java.util.*;

public class Solution2 {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        PriorityQueue<Integer> container = new PriorityQueue<>(d, Integer::compareTo);
        PriorityQueue<Integer> supportContainer = new PriorityQueue<>(d, Integer::compareTo);
        int[] buffer = new int[expenditure.length];

        int counter = 0;
        boolean containerSwitch = true;

        for (int i = 0; i < expenditure.length; i++) {
            buffer[i] = expenditure[i];

            if (i >= d) {

                double median;
                int toRemove = buffer[i - d];

                if (containerSwitch) {
                    median = getMedian(container, supportContainer, toRemove);
                } else {
                    median = getMedian(supportContainer, container, toRemove);
                }

                System.out.println();
                System.out.println(median);


                containerSwitch = !containerSwitch;

                if (expenditure[i] >= median * 2) {
                    counter++;
                }
            }

            if (containerSwitch) {
                container.add(expenditure[i]);
            } else {
                supportContainer.add(expenditure[i]);
            }
            //System.out.println();
        }

        return counter;
    }


    public static double getMedian(
        PriorityQueue<Integer> container,
        PriorityQueue<Integer> supportContainer,
        int avoidValue) {

        int i = 0;
        int center = container.size() / 2;
        boolean even = container.size() % 2 == 0;
        boolean flag = false;
        double median = 0;

        while (!container.isEmpty()) {
            Integer value = container.poll();
            boolean isAvoidValue = value.equals(avoidValue);

            System.out.print(value + ", ");

            if (!isAvoidValue || flag) {
                supportContainer.add(value);
            } else {
                flag = true;
            }

            if (even) {
                if (center - 1 == i) {
                    Integer value2 = container.poll();
                    isAvoidValue = value2.equals(avoidValue);

                    System.out.print(value2 + ", ");

                    if (!isAvoidValue || flag) {
                        supportContainer.add(value);
                    } else {
                        flag = true;
                    }

                    median = (value.doubleValue() + value2.doubleValue()) / 2;
                }
            } else {
                if (center == i) {
                    median = value.doubleValue();
                }
            }

            i++;
        }

        return median;
    }

    public static void main(String[] args)  {
        int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5, 9};
        int result = activityNotifications(expenditure, 5);

        //System.out.println(result);
    }
}
