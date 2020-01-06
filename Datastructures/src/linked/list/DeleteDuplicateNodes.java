package linked.list;

import java.util.HashSet;

public class DeleteDuplicateNodes {

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode node = head;
        HashSet<Integer> set = new HashSet<>();

        if (node.next == null) {
            return head;
        } else {
            set.add(node.data);
        }

        while (node.next != null) {
            if (set.contains(node.next.data)) {
                if (node.next.next == null) {
                    node.next = null;
                    break;
                } else {
                    node.next = node.next.next;
                    continue;
                }
            }

            set.add(node.next.data);
            node = node.next;
        }

        return head;
    }
}
