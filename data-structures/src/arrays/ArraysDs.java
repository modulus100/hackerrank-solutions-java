package arrays;

public class ArraysDs {

    public static void main(String[] args) {
        for (int element : reverseArray(new int[] {1, 2, 3, 4})) {
            System.out.print(element + ", ");
        }
    }

    public static int[] reverseArray(int[] a) {
        int[] arr = new int[a.length];

        for (int i = 0, j = a.length -1; i < a.length; i++, j--) {
            arr[i] = a[j];
        }

        return arr;
    }
}
