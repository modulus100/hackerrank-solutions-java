package string.manipulation;

public class SpecialStringAgain {

    public static void main(String[] args) {
        long result = substrCount2(2, "aaa");
        System.out.println("result: " + result);
    }

    static long substrCount(int n, String s) {
        long specialSubStringNum = 0;


        return specialSubStringNum;
    }

    public static long substrCount2(int length, String s) {
        long counter = 0;
        for (int i = 0; i < length; i++) {
            // if the current symbol is in the middle of palindrome, e.g. aba
            int offset = 1;
            while (i - offset >= 0
                    && i + offset < length
                    && s.charAt(i - offset) == s.charAt(i - 1)
                    && s.charAt(i + offset) == s.charAt(i - 1)) {

                counter++;
                offset++;
            }
            // if this is repeatable characters aa
            int repeats = 0;
            while (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
                repeats++;
                i++;
            }
            counter += repeats * (repeats + 1) / 2;
        }
        return counter + length;
    }
}
