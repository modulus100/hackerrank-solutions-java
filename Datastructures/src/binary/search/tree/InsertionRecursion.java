package binary.search.tree;

public class InsertionRecursion {

    public static Node insert(Node root,int data) {
        if (root == null) {
            return new Node(data);
        } else {
            internalInsert(root, data);
        }

        return root;
    }

    private static void internalInsert(Node root, int data) {
        if (root.data > data) {
            if (root.left == null) {
                root.left = new Node(data);;
            } else {
                internalInsert(root.left, data);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(data);;
            } else {
                internalInsert(root.right, data);
            }
        }
    }
}
