package binary.search.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

// https://www.youtube.com/watch?v=c3SAvcjWb1E
// https://www.hackerrank.com/challenges/tree-top-view/problem?h_r=next-challenge&h_v=zen
public class TopView {

    public static class NodeWrapper {
        Node node;
        int level;

        public NodeWrapper(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void topView(Node root) {
        TreeMap<Integer, NodeWrapper> nodeMap = new TreeMap<>();
        Queue<NodeWrapper> nQueue = new LinkedList<>();
        nQueue.add(new NodeWrapper(root, 0));

        while (!nQueue.isEmpty()) {
            NodeWrapper nWrapper = nQueue.poll();

            if (!nodeMap.containsKey(nWrapper.level)) {
                nodeMap.put(nWrapper.level, nWrapper);
            }

            if (nWrapper.node.left != null) {
                nQueue.add(new NodeWrapper(nWrapper.node.left, nWrapper.level - 1));
            }

            if (nWrapper.node.right != null) {
                nQueue.add(new NodeWrapper(nWrapper.node.right, nWrapper.level + 1));
            }
        }

        for (NodeWrapper nWrapper : nodeMap.values()) {
            System.out.print(nWrapper.node.data + " ");
        }
    }
}
