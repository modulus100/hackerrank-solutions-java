package string.manipulation;

public class AlternatingCharacters {

    public static void main(String[] args) {
        int result = alternatingCharacters("ABBB");

        System.out.print(result);
    }

    static int alternatingCharacters(String s) {
        int deleteCount = 0;
        if (s.length() == 0) return deleteCount;

        char prev = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                deleteCount++;
            } else {
                prev = s.charAt(i);
            }
        }

        return deleteCount;
    }
}