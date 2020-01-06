package linked.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindMergePoint {

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        HashMap<Integer, List<SinglyLinkedListNode>> map =  new HashMap<>();
        SinglyLinkedListNode node1 = head1;
        SinglyLinkedListNode node2 = head2;

        while(node1 != null) {
            if (map.containsKey(node1.data)) {
                List list = map.get(node1.data);
                list.add(node1);
            } else {
                ArrayList<SinglyLinkedListNode> aList = new ArrayList<>();
                aList.add(node1);
                map.put(node1.data, aList);
            }

            node1 = node1.next;
        }

        while(node2 != null) {
            if (map.containsKey(node2.data)) {
                for (SinglyLinkedListNode node : map.get(node2.data)) {
                    if (node2 == node) {
                        return node.data;
                    }
                }
            }

            node2 = node2.next;
        }

        return 0;
    }
}
