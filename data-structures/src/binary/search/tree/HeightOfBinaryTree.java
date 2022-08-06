package binary.search.tree;

public class HeightOfBinaryTree {

    public static int height(Node root) {
        if (root == null)
            return 0;
        else
        {
            if (root.left == null && root.right == null) {
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            if (leftHeight > rightHeight)
                return (leftHeight + 1);
            else
                return (rightHeight + 1);
        }
    }
}