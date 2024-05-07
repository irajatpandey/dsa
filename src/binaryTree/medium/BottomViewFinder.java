package binaryTree.medium;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BottomViewFinder {

    public static void printBottomView(TreeNode<Integer> root, Map<Integer, Pair2> map, int horizontalDistance, int level) {
        if(root == null) return;

        if (!map.containsKey(horizontalDistance) || level >= map.get(horizontalDistance).level) {
            map.put(horizontalDistance, new Pair2(level, root.data));
        }
        printBottomView(root.left, map, horizontalDistance - 1, level + 1);
        printBottomView(root.right, map, horizontalDistance + 1, level + 1);
    }
    public static List<Integer> findBottomViews(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Pair2> map = new TreeMap<>();

        printBottomView(root, map, 0, 0);

        for(Pair2 pair : map.values()) {
            result.add(pair.data);
        }
        return result;
    }

    public static void main(String[] args) {
        /* Example Binary Tree:
                         26
                        /   \
                      34     2
                     /  \   / \
                    24  27 9   7
                        / \     \
                       25  1    21
                              \
                               8
                                \
                                14
                                 \
                                 18
        */
        TreeNode<Integer> root = new TreeNode<>(26);
        root.left = new TreeNode<>(34);
        root.right = new TreeNode<>(2);
        root.left.left = new TreeNode<>(24);
        root.left.right = new TreeNode<>(27);
        root.right.left = new TreeNode<>(9);
        root.right.right = new TreeNode<>(7);
        root.left.right.left = new TreeNode<>(25);
        root.left.right.right = new TreeNode<>(1);
        root.right.right.right = new TreeNode<>(21);
        root.right.right.right.right = new TreeNode<>(14);
        root.right.right.right.right.right = new TreeNode<>(8);
        root.right.right.right.right.right.right = new TreeNode<>(18);

        List<Integer> bottomViews = findBottomViews(root);
        System.out.println(bottomViews);
    }
}
