package binary.search.tree;

import java.util.HashMap;
import java.util.Stack;

// https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem
public class LowestCommonAncestor {

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(9);

        root.left.left = new Node(1);
        root.left.right = new Node(6);

        root.left.right.left = new Node(5);

        root.left.left.right = new Node(2);
        root.left.left.right.right = new Node(3);

        Node lca = lca(root, 1, 2);

        if (lca != null) {
            System.out.println(lca.data);
        }
    }

    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        HashMap<Integer, Node> map1 = new HashMap<>();
        Stack<Node> stack1 = new Stack<>();
        HashMap<Integer, Node> map2 = new HashMap<>();
        Stack<Node> stack2 = new Stack<>();

        findPath(map1, stack1, root, v1);
        findPath(map2, stack2, root, v2);

        if (stack1.size() > stack2.size()) {
            return getMatch(stack1, map2);
        } else {
            return getMatch(stack2, map1);
        }
    }

    private static Node getMatch(Stack<Node> stack, HashMap<Integer, Node> map) {
        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if (map.containsKey(node.data)) {
                return map.get(node.data);
            }
        }

        return null;
    }

    private static void findPath(
            HashMap<Integer, Node> map,
            Stack<Node> stack,
            Node node,
            int v) {

        if (node == null)  {
            return;
        }

        if (!map.containsKey(node.data)) {
            map.put(node.data, node);
            stack.add(node);
        }

        if (node.data == v) {
            return;
        }

        if (node.data > v) {
            findPath(map, stack, node.left, v);
        } else {
            findPath(map, stack, node.right, v);
        }
    }
}
