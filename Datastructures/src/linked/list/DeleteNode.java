package linked.list;

public class DeleteNode {

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if (head == null) { return head; }
        if (position == 0) {
            head = head.next;
            return head;
        }

        SinglyLinkedListNode node = head;
        int index = 1;

        while (node.next != null) {
            if (index == position) {
                node.next = node.next.next;
                break;
            }

            node = node.next;
            index++;
        }

        return head;
    }
}
