package linked.list;

public class SortedInsertDoubleLinkedList {

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        if (head == null) {
            head = new DoublyLinkedListNode(data);
            return head;
        }

        DoublyLinkedListNode node = head;
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if (data < head.data) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        node = node.next;

        while (node != null) {
            if (data >= node.data && node.next == null) {
                newNode.prev = node;
                node.next = newNode;
                break;
            } else if (data >= node.data && data < node.next.data) {
                newNode.prev = node;
                newNode.next = node.next;
                node.next = newNode;
                break;
            }

            node = node.next;
        }

        return head;
    }
}
