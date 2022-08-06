package linked.list;

public class InsertAtTail {

    public static void main(String[] args) {

    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode node = head;

        if (head == null) {
            head = new SinglyLinkedListNode(data);
        } else {
            while (node.next != null) {
                node = node.next;
            }

            node.next = new SinglyLinkedListNode(data);
        }

        return head;
    }
}
