package bit.manipulation;

public class SansaXor {

    static int sansaXor(int[] arr) {
        if (arr.length % 2 == 0) return 0;
        int result = arr[0];

        for (int i = 2; i < arr.length; i+= 2) {
            result ^= arr[i];
        }

        return result;
    }
}
