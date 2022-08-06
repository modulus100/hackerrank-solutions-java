package linked.list;

import java.util.Stack;

public class ReverseDoublyLinkedList {

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        Stack<Integer> stack = new Stack<>();
        DoublyLinkedListNode node = head;
        DoublyLinkedListNode reversedHead = null;
        DoublyLinkedListNode prev = null;

        while (node != null) {
            stack.push(node.data);
            node = node.next;
        }

        while (!stack.empty()) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(stack.pop());

            if (reversedHead == null) {
                reversedHead = newNode;
            } else {
                newNode.prev = prev;
                prev.next = newNode;
            }

            prev = newNode;
        }

        return reversedHead;
    }
}
