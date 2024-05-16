package BinarySearchTree.interview;

import BinarySearchTree.BinarySearchTree;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LCA {

    /**
     * Time complexity: O(h), where h is the height of the binary search tree.
     * Space complexity: O(h), where h is the height of the binary search tree, due to the recursive calls stored on the call stack.
     * Finds the Lowest Common Ancestor (LCA) of two nodes in a Binary Search Tree (BST).
     *
     * @param root The root node of the BST.
     * @param p    The first node.
     * @param q    The second node.
     * @return The lowest common ancestor node.
     */
    //
    private static BinarySearchTree<Integer> lowestCommonAncestor(BinarySearchTree<Integer> root, BinarySearchTree<Integer> p, BinarySearchTree<Integer> q) {
        if (root == null) {
            return null; // Base case: if root is null, return null
        }

        // If both p and q are less than root's value, search in the left subtree
        if (p.data < root.data && q.data < root.data) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // If both p and q are greater than root's value, search in the right subtree
        else if (p.data > root.data && q.data > root.data) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // Otherwise, root is the lowest common ancestor
        else {
            return root;
        }
    }

    public static void main(String[] args) {
        /*
                    6
                  /  \
                 2    8
                / \  / \
               0  4  7  9
                 / \
                 3   5
        */
        // Constructing the binary search tree
        BinarySearchTree<Integer> root = new BinarySearchTree<>(6);
        root.left = new BinarySearchTree<>(2);
        root.right = new BinarySearchTree<>(8);
        root.left.left = new BinarySearchTree<>(0);
        root.left.right = new BinarySearchTree<>(4);
        root.right.left = new BinarySearchTree<>(7);
        root.right.right = new BinarySearchTree<>(9);
        root.left.right.left = new BinarySearchTree<>(3);
        root.left.right.right = new BinarySearchTree<>(5);

        // Choosing the nodes for which LCA needs to be found
        BinarySearchTree<Integer> p = root.left;
        BinarySearchTree<Integer> q = root.left.right.right;

        // Finding the lowest common ancestor
        BinarySearchTree<Integer> lca = lowestCommonAncestor(root, p, q);

        // Printing the result
        System.out.println("Lowest Common Ancestor of " + p.data + " and " + q.data + " is: " + lca.data);
    }
}
