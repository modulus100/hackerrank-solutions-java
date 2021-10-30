package arrays;

import java.util.HashSet;


public class MinimumSwaps2 {

    static int minimumSwaps(int[] arr) {
        HashSet<Integer> cache = new HashSet<>();
        int numOfSwaps = 0;

        for (int i = 0; i <= arr.length; i++) {
            if (arr[i] != i + 1) {
                if (cache.contains(arr[i])) {
                    int index = findLeftIndex(i - 1, i + 1, arr);
                    swap(i, index, arr);
                } else {
                    int index = findRightIndex(i + 1, i + 1, arr);
                    swap(i, index, arr);
                    cache.add(arr[i]);
                }

                numOfSwaps++;
            }
        }

        return numOfSwaps;
    }

    static int findLeftIndex(int start, int value, int[] arr) {
        for (int i = start; i > 0; i--) {
            if (arr[i] == value) {
                return i;
            }
        }

        return 0;
    }

    static void swap(int first, int second, int[] arr) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int findRightIndex(int start, int value, int[] arr) {
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }

        return arr.length - 1;
    }
}
