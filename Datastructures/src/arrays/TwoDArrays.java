package arrays;

public class TwoDArrays {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        System.out.println(hourglassSum(arr));
    }

    public static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr.length - i < 3) break;

            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i].length - j < 3) break;

                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                                + arr[i + 1][j + 1]
                                + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }
}
