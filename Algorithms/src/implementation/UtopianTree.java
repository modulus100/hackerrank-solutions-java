package implementation;

public class UtopianTree {

    static int utopianTree(int n) {
        if (n < 3) return n + 1;
        if (n % 2 == 0) return (utopianTree(n - 2) * 2) + 1;
        return (utopianTree(n - 2) + 1) * 2;
    }
}
