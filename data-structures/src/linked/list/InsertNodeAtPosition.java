package linked.list;

public class InsertNodeAtPosition {

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        if (head == null) { return new SinglyLinkedListNode(data); }
        if (position == 0) {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            newNode.next = head;
            return newNode;
        } else {
            SinglyLinkedListNode node = head;
            int index = 1;

            while (node.next != null) {
                if (index == position) {
                    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
                    newNode.next = node.next;
                    node.next = newNode;
                    break;
                }
                node = node.next;
                index++;
            }
        }

        return head;
    }
}
