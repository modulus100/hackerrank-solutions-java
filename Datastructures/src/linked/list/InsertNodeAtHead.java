package linked.list;

public class InsertNodeAtHead {

    public static void main(String[] args) {

    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);

        if (llist == null) {
            return new SinglyLinkedListNode(data);
        } else {
            node.next = llist;
        }

        return node;
    }
}
