package arrays;

public class LeftRotation {

    public static void main(String[] args) {
        for (int value: leftRotation(4, new int[] { 1, 2, 3, 4, 5})) {
            System.out.print(value);
            System.out.print(" ");
        }
    }

    public static int[] leftRotation(int d, int[] foo) {
        int[] bar = new int[foo.length];

        for (int i = 0; i < foo.length; i++) {
            bar[i] = foo[(i + d) % foo.length];
        }

        return bar;
    }
}
