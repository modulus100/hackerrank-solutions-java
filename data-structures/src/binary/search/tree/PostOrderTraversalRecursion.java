package binary.search.tree;

//hackerrank.com/challenges/tree-postorder-traversal/problem?h_r=next-challenge&h_v=zen
public class PostOrderTraversalRecursion {

    public static void postOrder(Node root) {
        if (root == null) { return; }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}
