package binaryTree.hard;

import binaryTree.TreeNode;

public class CompleteBinaryTreeNodeCounter {
    /*
    * Time Complexity: O(log N * log N) where N is the number of nodes in the Binary Tree.

The calculation of leftHeight and rightHeight takes O(log N) time.
In the worst case, when encountering the second case (leftHeight != rightHeight), the recursive calls are made at most log N times (the height of the tree).
Therefore, the total time complexity is O(log N * log N).
Space Complexity : O(H) ~ O(N) where N is the number of nodes in the Binary Tree.

The space complexity is determined by the maximum depth of the recursion stack, which is equal to the height of the binary tree.
Since the given tree is a complete binary tree, the height will always be log N.
Therefore, the space complexity is O(log N).
    * */
    public static int findHeightLeft(TreeNode<Integer> node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    // Function to find the
    // height of the right subtree
    public static int findHeightRight(TreeNode<Integer> node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
    public static int getCountOfCompleteBinaryTreeNode(TreeNode<Integer> root){
        if(root == null) return 0;
        int leftHeight = findHeightLeft(root);
        int rightHeight = findHeightRight(root);

        if(leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
        else{
            return 1 + getCountOfCompleteBinaryTreeNode(root.left) + getCountOfCompleteBinaryTreeNode(root.right);
        }
    }
    public static void main(String[] args) {

        /*       1
               /   \
              2     3
             / \   / \
            4   5 6   7   */
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);

        System.out.println("Total Number of nodes is " + getCountOfCompleteBinaryTreeNode(root));

    }
}
