package dictionaries.and.hashmaps;

import java.util.HashSet;

public class TwoStrings {

    static String twoStrings(String s1, String s2) {
        HashSet<Character> set = new HashSet<>();

        for (char currentChar : s1.toCharArray()) {
            set.add(currentChar);
        }

        for (char currentChar : s2.toCharArray()) {
            if (set.contains(currentChar)) {
                return "YES";
            }
        }

        return "NO";
    }
}
