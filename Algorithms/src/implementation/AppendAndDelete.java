package implementation;

// just a playground, tried different approaches
public class AppendAndDelete {

    public static void main(String[] arg) {
        System.out.println(appendAndDelete("zzzzz", "zzzzzzz", 4));
    }

    static String appendAndDelete(String s, String t, int k) {
        if (s.length() >= t.length()) {
            return appendAndDeleteWrapper1(s, t, k);
        } else {
            return appendAndDeleteWrapper2(t, s, k);
        }
    }

    static String appendAndDeleteWrapper1(String s, String t, int k) {
        if (s.isEmpty() && t.isEmpty()) {
            return "Yes";
        }

        int count = 0;
        int lengthDiffCount = 0;
        boolean startCount = false;
        boolean similar = false;

        for (int i = 0; i < s.length(); i++) {
            if (i < t.length()) {
                if (s.charAt(i) != t.charAt(i)) {
                    startCount = true;
                }
            } else {
                startCount = true;
                lengthDiffCount++;
            }

            if (startCount) {
                count++;
            }

            int numOfOperations = count + count - lengthDiffCount;
            if (numOfOperations > k) {
                return "No";
            }
        }

        return "Yes";
    }

    static String appendAndDeleteWrapper2(String s, String t, int k) {
        if (s.isEmpty() && t.isEmpty()) {
            return "Yes";
        }

        int count = 0;
        int lengthDiffCount = 0;
        boolean startCount = false;
        boolean similar = true;
        int numOfOp = 0;
        char prev = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (i < t.length()) {
                startCount = true;
            } else {
                lengthDiffCount++;
            }

            if (s.charAt(i) != prev) {
                similar = false;
            }

            if (startCount) {
                count++;
            }

            int numOfOperations = count + count - lengthDiffCount;
            numOfOp = numOfOperations;
            if (numOfOperations >= k && !similar) {
                return "No";
            }

        }

        if (similar && numOfOp < k) {
            return "Yes";
        }

        return "Yes";
    }
}
