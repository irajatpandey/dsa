package binaryTree.medium;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-right-side-view/description/
public class RightViewFinder {
    static int maxLevel = -1;

    //the time complexity of the recursive approach is O(n), where n is the number of nodes in the tree.
    //The space complexity of the recursive approach depends on the maximum depth of the recursive call stack.
    //In the worst case, where the tree is completely unbalanced (like a linked list), the depth of the recursion can be n, leading to a space complexity of O(n) for the call stack.
    //Additionally, we need space to store the output list, which in the worst case can also be O(n).
    //Therefore, the overall space complexity is O(n) in the worst case.
    private static void printRightView(TreeNode<Integer> root, List<Integer> list, int level) {
        if(root == null) return;

        if(level > maxLevel){
            list.add(root.data);
            maxLevel = level;
        }

        printRightView(root.right, list, level + 1);
        printRightView(root.left, list, level + 1);

    }
    public static List<Integer> rightViewFinder(TreeNode<Integer> root) {
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        printRightView(root, list, 0);
        return list;
    }

    public static void main(String[] args) {

/* Example Binary Tree:
                        1
                       / \
                      2   3
                     / \ / \
                    4  5 6  7
                       / \
                      8   9
                     /     \
                    10      11
                          /    \
                         12    13
                       /   \   / \
                      14   15 16 17
        */
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        root.left.right.left = new TreeNode<>(8);
        root.left.right.left.left = new TreeNode<>(10);
        root.left.right.right = new TreeNode<>(9);
        root.left.right.right.right = new TreeNode<>(11);
        root.left.right.right.right.left = new TreeNode<>(12);
        root.left.right.right.right.right = new TreeNode<>(13);
        root.left.right.right.right.left.left = new TreeNode<>(14);
        root.left.right.right.right.left.right = new TreeNode<>(15);
        root.left.right.right.right.right.left = new TreeNode<>(16);
        root.left.right.right.right.right.right = new TreeNode<>(17);

        System.out.println(rightViewFinder(root));
    }
}
