package recursion;

import java.util.Arrays;

public class SuperDigit {

    public static int superDigit(String n, int k) {
        if (n.length() == 1) return Integer.parseInt(n);
        final var str = Arrays.stream(n.repeat(k).split(""))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum)
                .toString();

        return superDigit(str, 1);
    }

    static int superDigit2(String n, int k) {
        if (n.length() > 1) {
            var sum = Arrays.stream(n.split(""))
                    .map(Long::parseLong)
                    .reduce(0L, Long::sum);

            return superDigit2(Long.toString(sum * k), 1);
        }

        return Character.getNumericValue(n.charAt(0));
    }
}
