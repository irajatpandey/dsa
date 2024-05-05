package binaryTree.medium;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
//Time Complexity: O(n)
//Space Complexity: O(n + h), where n is the number of nodes and h is the height of the tree.
public class BoundaryTraversal {
    public static void traverseLeft(TreeNode<Integer> root, List<Integer> list) {
        // Base Condition
        if (root == null || root.left == null && root.right == null) {
            return;
        }

        list.add(root.data);
        if(root.left != null) {
            traverseLeft(root.left, list);
        }
        else{
            traverseLeft(root.right, list);
        }

    }
    public static void traverseLeaf(TreeNode<Integer> root, List<Integer> list) {
        // Base Condition
        if (root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            list.add(root.data);
        }

        traverseLeaf(root.left, list);
        traverseLeaf(root.right, list);

    }
    public static void traverseRight(TreeNode<Integer> root, List<Integer> list) {
        // Base Condition
        if (root == null || root.left == null && root.right == null) {
            return;
        }

        if(root.right != null) {
            traverseRight(root.right, list);
        }
        else {
            traverseRight(root.left, list);
        }
        list.add(root.data);
    }
    public static void boundaryTraversal(TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.data);
        traverseLeft(root.left, list);
        traverseLeaf(root.left, list);
        traverseLeaf(root.right, list);
        traverseRight(root.right, list);
        System.out.println(list);
    }
    public static void main(String[] args) {
        /*        10
                /    \
               7      20
              / \    /  \
             4   9  15   25
                / \      / \
               8  11    22  30
                        / \
                       21  24
        */
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(7);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(9);
        root.left.right.left = new TreeNode<>(8);
        root.left.right.right = new TreeNode<>(11);
        root.right.left = new TreeNode<>(15);
        root.right.right = new TreeNode<>(25);
        root.right.right.left = new TreeNode<>(22);
        root.right.right.left.left = new TreeNode<>(21);
        root.right.right.left.right = new TreeNode<>(24);
        root.right.right.right = new TreeNode<>(30);
        System.out.println("Boundary Traversal:");
        boundaryTraversal(root);
    }
}
