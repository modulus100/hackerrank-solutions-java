package warm.up;

import java.util.Collections;
import java.util.List;

public class MiniMaxSum {

    public static void miniMaxSum(List<Long> arr) {
        var sum = arr.stream().reduce(0L, Long::sum);
        System.out.println((sum - Collections.max(arr)) + " " + (sum - Collections.min(arr)));
    }
}
