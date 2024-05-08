package binaryTree.medium;
import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeftViewFinder {
    static int maxLevel = -1;
    //    //the time complexity of the recursive approach is O(n), where n is the number of nodes in the tree.
    //    //The space complexity of the recursive approach depends on the maximum depth of the recursive call stack.
    //    //In the worst case, where the tree is completely unbalanced (like a linked list), the depth of the recursion can be n, leading to a space complexity of O(n) for the call stack.
    //    //Additionally, we need space to store the output list, which in the worst case can also be O(n).
    //    //Therefore, the overall space complexity is O(n) in the worst case.
    private static void printLeftView(TreeNode<Integer> root, List<Integer> list, int level) {
        if(root == null) return;

        if(level > maxLevel){
            list.add(root.data);
            maxLevel = level;
        }

        printLeftView(root.left, list, level + 1);
        printLeftView(root.right, list, level + 1);

    }
    public static List<Integer> leftViewFinder(TreeNode<Integer> root) {
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        printLeftView(root, list, 0);

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
                         /
                        10
        */
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        root.left.right.left = new TreeNode<>(8);
        root.left.right.right = new TreeNode<>(9);
        root.left.right.right.left = new TreeNode<>(10);

        System.out.println(leftViewFinder(root));
    }
}
