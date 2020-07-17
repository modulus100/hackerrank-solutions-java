package string.manipulation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MakingAnagrams {

    public static void main(String[] args) {
        int result = makeAnagram("ccdde", "abc");

        System.out.print("result: " + result);
    }

    static int makeAnagram(String a, String b) {
        HashMap<Character, Integer> aMap = new HashMap<>();
        HashMap<Character, Integer> bMap = new HashMap<>();
        int max = Math.max(a.length(), b.length());
        int deleteCount = 0;

        for (int i = 0; i < max; i++) {
            if (i < a.length()) {
                char key = a.charAt(i);
                updateMap(key, aMap);
            }

            if (i < b.length()) {
                char key = b.charAt(i);
                updateMap(key, bMap);
            }
        }

        for (int i = 0; i < max; i++) {
            if (i < a.length()) {
                deleteCount += count(a.charAt(i), bMap, aMap);
            }

            if (i < b.length()) {
                deleteCount += count(b.charAt(i), aMap, bMap);
            }
        }

        return deleteCount;
    }

    static int count(char key, HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        if (!map1.containsKey(key)) {
            return 1;
        } else {
            int aCount = map2.get(key);
            int bCount = map1.get(key);

            if (aCount > 1 || bCount > 1) {
                map2.put(key, 1);
                map1.put(key, 1);
                return Math.abs(aCount - bCount);
            }
        }

        return 0;
    }

    static void updateMap(char key, HashMap<Character, Integer> charMap) {
        if (charMap.containsKey(key)) {
            int count = charMap.get(key);
            charMap.put(key, ++count);
        } else {
            charMap.put(key, 1);
        }
    }
}
