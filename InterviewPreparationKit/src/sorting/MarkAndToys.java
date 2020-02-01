package sorting;

import java.util.PriorityQueue;

public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int sum = 0;
        int maxToys = 0;

        for (int price : prices) {
            q.add(price);
        }

        while (!q.isEmpty()) {
            int price = q.poll();
            sum = sum + price;

            if (sum > k) {
                return maxToys;
            }

            maxToys++;
        }

        return maxToys;
    }
}
