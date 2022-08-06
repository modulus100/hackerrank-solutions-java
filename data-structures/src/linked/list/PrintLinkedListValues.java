package linked.list;

public class PrintLinkedListValues {

    public static void main(String[] args) {

    }

    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode node = head;

        while(node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}
