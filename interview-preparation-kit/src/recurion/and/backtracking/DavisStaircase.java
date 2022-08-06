package recurion.and.backtracking;

import java.util.HashMap;

public class DavisStaircase {

    private static final HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(stepPerms(3));
    }

    static int stepPerms(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (!map.containsKey(n)) {
            int result = stepPerms(n - 3) + stepPerms(n - 2) + stepPerms(n - 1);
            map.put(n, result);
        }

        return map.get(n);
    }
}
