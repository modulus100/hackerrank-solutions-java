package string.manipulation;

import java.util.Stack;

public class BalancedParentheses {

    public static void main(String[] args) {
        boolean result = equationChecker("((3^2 + 8)*(5/2))/(2+6)");

        System.out.println(result);
    }

    public static boolean equationChecker(String equation) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < equation.length(); i++) {
            char currentChar = equation.charAt(i);

            if (currentChar == '(') {
                stack.push(currentChar);
            } else if (currentChar == ')') {
                if (stack.empty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.empty();
    }
}
