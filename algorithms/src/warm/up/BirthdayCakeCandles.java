package warm.up;

import java.util.HashMap;
import java.util.List;

public class BirthdayCakeCandles {

    public static void main(String[] ars) {

    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (Integer candle : candles) {
            if (map.containsKey(candle)) {
                int count = map.get(candle) + 1;

                if (count > max) {
                    max = count;
                }

                map.put(candle, count);
            } else {
                map.put(candle, 1);
            }
        }

        return max;
    }
}
