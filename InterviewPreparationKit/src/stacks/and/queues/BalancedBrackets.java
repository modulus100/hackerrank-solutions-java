package stacks.and.queues;

import java.util.LinkedList;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));
    }

    static String isBalanced(String s) {
        char a1 = '{';
        char a2 = '}';
        char b1 = '[';
        char b2 = ']';
        char c1 = '(';
        char c2 = ')';

        Stack<Character> q = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (q.isEmpty() || c == a1 || c == b1 || c == c1) {
                q.add(c);
            } else {
                Character bracket = q.pop();

                if (c == a2 && bracket != a1
                        || c == b2 && bracket != b1
                        || c == c2 && bracket != c1 ) {
                    return "NO";
                }
            }
        }

        return q.size() == 0 ? "YES" : "NO";
    }
}
