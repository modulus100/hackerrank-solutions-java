package linked.list;

import java.util.Stack;

public class GetValueFromTail {

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode node = head;
        Stack<Integer> stack = new Stack<>();
        int value = 0;

        while (node != null) {
            stack.push(node.data);
            node = node.next;
        }

        while (positionFromTail >= 0) {
            value = stack.pop();
            positionFromTail--;
        }

        return value;
    }
}
