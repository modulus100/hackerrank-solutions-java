package linked.list;

public class CompareTwoLinkedLists {

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode node1 = head1;
        SinglyLinkedListNode node2 = head2;

        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        while (node1 != null || node2 != null) {
            if (node1 == null || node2 == null || node1.data != node2.data) {
                return false;
            }

            node1 = node1.next;
            node2 = node2.next;
        }

        return true;
    }
}
