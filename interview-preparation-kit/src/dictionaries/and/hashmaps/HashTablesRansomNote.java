package dictionaries.and.hashmaps;

import java.util.HashMap;

public class HashTablesRansomNote {

    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> countMap = new HashMap<>();

        for (String word : magazine) {
            if (countMap.containsKey(word)) {
                countMap.put(word, countMap.get(word) + 1);
            } else {
                countMap.put(word, 1);
            }
        }

        for (String word : note) {
            if (countMap.containsKey(word)) {
                int counter = countMap.get(word);

                if (counter == 0) {
                    System.out.println("No");
                    return;
                } else {
                    countMap.put(word, countMap.get(word) - 1);
                }
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }

}
