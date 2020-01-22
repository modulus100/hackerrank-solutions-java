package warm.up;

public class RepeatedString {

    static long repeatedString(String s, long n) {
        long count = 0;
        long remainderCount = 0;
        long numOfRepeatedStrings = (long) (n / s.length());

        // in string
        for (char currentChar : s.toCharArray()) {
            if (currentChar == 'a') {
                count++;
            }
        }

        // in remainder
        for (int i = 0; i < n % s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == 'a') {
                remainderCount++;
            }
        }

        return numOfRepeatedStrings * count + remainderCount;
    }
}
