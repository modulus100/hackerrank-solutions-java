package warm.up;

public class PlusMinus {

    public static void main(String[] args) {
        plusMinus(new int[] {1, 0, -1});
    }

    static void plusMinus(int[] arr) {
        int negative = 0;
        int positive = 0;
        int zero = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zero++;
            } else if (arr[i] > 0) {
                positive++;
            } else {
                negative++;
            }
        }

        System.out.println((double) positive/arr.length);
        System.out.println((double) negative/arr.length);
        System.out.println((double) zero/arr.length);
    }
}
