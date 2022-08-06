package linked.list;

public class Reverse {

    static void reversePrint(SinglyLinkedListNode head) {
        SinglyLinkedListNode node = head;
        SinglyLinkedListNode reversed = null;

        while (node != null) {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(node.data);

            if (reversed != null) {
                newNode.next = reversed;
            }

            reversed = newNode;
            node = node.next;
        }

        node = reversed;

        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}
