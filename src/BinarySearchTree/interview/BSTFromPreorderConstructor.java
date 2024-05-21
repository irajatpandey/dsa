package BinarySearchTree.interview;

import BinarySearchTree.BinarySearchTree;
//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
public class BSTFromPreorderConstructor {

    // Index to keep track of current position in the preorder array
    static int index = 0;

    /**
     * Time complexity: O(n) - where n is the number of nodes in the binary search tree, as each node in the preorder traversal array is processed once.
     * Space complexity: O(n) - due to the recursive stack space used during the construction of the binary search tree.
     * Constructs a binary search tree from a preorder traversal array.
     *
     * @param preorder The preorder traversal array
     * @return The root of the constructed binary search tree
     */
    private static BinarySearchTree<Integer> bstFromPreorder(int[] preorder, int min, int max) {
        // If all elements from preorder array are processed, return null
        if (index == preorder.length) return null;

        int val = preorder[index];
        // If the current value is not within the range of min and max, it's not part of the current subtree
        if (val < min || val > max) return null;

        // Create a new node with the current value
        BinarySearchTree<Integer> root = new BinarySearchTree<>(val);
        index++;
        // Recursively construct left and right subtrees
        root.left = bstFromPreorder(preorder, min, val);
        root.right = bstFromPreorder(preorder, val, max);

        return root;
    }

    /**
     * Constructs a binary search tree from a preorder traversal array.
     *
     * @param preorder The preorder traversal array
     * @return The root of the constructed binary search tree
     */
    public static BinarySearchTree<Integer> bstFromPreorder(int[] preorder) {
        // If the preorder array is null or empty, return null
        if (preorder == null || preorder.length == 0) return null;
        // Start constructing the binary search tree recursively
        return bstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        // Construct the binary search tree
        BinarySearchTree<Integer> root = bstFromPreorder(preorder);
        System.out.println("Inorder Traversal of Constructed BST:");
        // Print the inorder traversal to verify the constructed binary search tree
        printInorder(root);
    }

    /**
     * Prints the inorder traversal of a binary search tree.
     *
     * @param node The root of the binary search tree
     */
    private static void printInorder(BinarySearchTree<Integer> node) {
        if (node == null) return;
        // Traverse left subtree
        printInorder(node.left);
        // Print current node's value
        System.out.print(node.data + " ");
        // Traverse right subtree
        printInorder(node.right);
    }
}
