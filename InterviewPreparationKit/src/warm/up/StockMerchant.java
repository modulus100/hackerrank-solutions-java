package warm.up;

import java.util.HashSet;

public class StockMerchant {

    static int sockMerchant(int n, int[] ar) {
        HashSet<Integer> sockPairs = new HashSet<>();
        int totalPairs = 0;

        for (int sock : ar) {
            if (sockPairs.contains(sock)) {
                sockPairs.remove(sock);
                totalPairs++;
            } else {
                sockPairs.add(sock);
            }
        }

        return totalPairs;
    }
}
