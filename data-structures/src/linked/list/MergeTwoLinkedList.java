package linked.list;

public class MergeTwoLinkedList {

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode node1 = head1;
        SinglyLinkedListNode node2 = head2;
        SinglyLinkedListNode merged = null;
        SinglyLinkedListNode mergedHead = null;

        while (node1 != null || node2 != null) {
            int value;
            boolean doubleValue = false;

            if (node1 == null || (node2 != null && node1.data > node2.data)) {
                value = node2.data;
                node2 = node2.next;
            } else if (node2 != null && node1.data == node2.data) {
                doubleValue = true;
                value = node2.data;
                node2 = node2.next;
                node1 = node1.next;
            } else {
                value = node1.data;
                node1 = node1.next;
            }


            if (doubleValue) {
                doubleValue = false;
                if (merged == null) {
                    merged = new SinglyLinkedListNode(value);
                    mergedHead = merged;
                    merged.next = new SinglyLinkedListNode(value);
                    merged = merged.next;
                } else {
                    merged.next = new SinglyLinkedListNode(value);
                    merged = merged.next;
                    merged.next = new SinglyLinkedListNode(value);
                    merged = merged.next;
                }
            } else {
                if (merged == null) {
                    merged = new SinglyLinkedListNode(value);
                    mergedHead = merged;
                } else {
                    merged.next = new SinglyLinkedListNode(value);
                    merged = merged.next;
                }
            }
        }

        return mergedHead;
    }
}
