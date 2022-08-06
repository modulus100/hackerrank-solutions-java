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
        if (n.length() == 1) return Character.getNumericValue(n.charAt(0));
        var sum = Arrays.stream(n.split(""))
                .map(Long::parseLong)
                .map(el -> el * k)
                .reduce(0L, Long::sum)
                .toString();

        return superDigit2(sum, 1);
    }

    static int superDigit3(String n, int k) {
        if (n.length() == 1) return Character.getNumericValue(n.charAt(0));
        return superDigit3(
                Arrays.stream(n.split(""))
                        .map(Long::parseLong)
                        .map(el -> el * k)
                        .reduce(0L, Long::sum)
                        .toString(), 1);
    }
}
