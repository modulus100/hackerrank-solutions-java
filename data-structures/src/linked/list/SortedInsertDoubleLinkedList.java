package linked.list;

public class SortedInsertDoubleLinkedList {

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        if (head == null) {
            head = new DoublyLinkedListNode(data);
            return head;
        }

        DoublyLinkedListNode node = head;
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if (data <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        while (node.next != null) {
            if (data > node.data && data <= node.next.data) {
                newNode.prev = node;
                newNode.next = node.next;
                node.next = newNode;
                node.next.prev = newNode;
                return head;
            }

            node = node.next;
        }

        newNode.prev = node;
        node.next = newNode;

        return head;
    }
}
