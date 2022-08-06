package miscellaneous;

public class TimeComplexityPrimality {

    static String primality(int n) {
        if (n == 0) return "Not prime";

        for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
            if (n % i == 0) return "prime";
        }

        return "Not prime";
    }
}
