package binaryTree.medium;
import binaryTree.TreeNode;

public class BinaryTreeBalancer {
    //The time complexity of the algorithm for checking if a binary tree is height-balanced is 𝑂(𝑛), where 𝑛 is the number of nodes in the binary tree.
    public static boolean isHeightBalanced(TreeNode<Integer> root) {
        // Helper function to calculate the height of the tree

        return getHeight(root) != -1;
    }
    private static int getHeight(TreeNode node) {
        // Base case: if node is null, return 0
        if (node == null) return 0;

        // Recursively calculate the height of the left and right subtrees
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // If any subtree is unbalanced or if the difference in heights is greater than 1,
        // then return -1 to indicate that the tree is not height-balanced
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Otherwise, return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static void main(String[] args) {
        /* Example Binary Tree:
                      1
                     / \
                    2   3
                   / \
                  4   5
                 /
                6
        */
        
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.left.left.left = new TreeNode<>(6);

        if(isHeightBalanced(root)){
            System.out.println("Height balanced");
        }
        else{
            System.out.println("Height unbalanced");
        }
    }
}
