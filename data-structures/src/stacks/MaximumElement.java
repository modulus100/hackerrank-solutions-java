package stacks;

import java.util.*;

public class MaximumElement {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> container = new PriorityQueue<>(Collections.reverseOrder());

        while (in.hasNext()) {
            int flag = in.nextInt();

            if (flag == 1) {
                int value = in.nextInt();
                stack.add(value);
                container.add(value);
            } else if (flag == 2 && !container.isEmpty()) {
                int value = stack.pop();
                container.remove(value);
            } else if (flag == 3 && !container.isEmpty()) {
                int value = container.peek();
                System.out.println(value);
            }
        }
    }
}
