package bold;

public class Bold {

    public static char[] reverseWords(char [] input) {
        int startIndex = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == ' ' || i == input.length - 1) {
                int lastCharIndex = i == input.length - 1 ? i : i - 1;

                while (startIndex < lastCharIndex) {
                    char temp = input[startIndex];
                    input[startIndex] = input[lastCharIndex];
                    input[lastCharIndex] = temp;

                    startIndex++;
                    lastCharIndex--;
                }

                startIndex = i + 1;
            }
        }

        return input;
    }
}
