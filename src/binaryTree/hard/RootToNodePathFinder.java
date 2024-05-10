package binaryTree.hard;

import binaryTree.TreeNode;
import java.util.ArrayList;
//https://leetcode.com/problems/binary-tree-paths/
public class RootToNodePathFinder {

    public static void getPaths(TreeNode<Integer> root, ArrayList<Integer> paths, ArrayList<ArrayList<Integer>> result) {
        if (root == null) {
            return;
        }
        paths.add(root.data);
        if(root.left == null && root.right == null) {
            result.add(new ArrayList<>(paths));
        }
        else {
            getPaths(root.left, paths, result);
            getPaths(root.right, paths, result);
        }
        paths.remove(paths.size() - 1);

    }
    public static ArrayList<ArrayList<Integer>> findPathFromRootToNode(TreeNode<Integer> root) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

        getPaths(root, new ArrayList<>(), paths);
        return paths;
    }
    public static void main(String[] args) {

        /*
                        1
                       / \
                      2   3
                     / \ / \
                    4  5 6  7
        */
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        System.out.println(findPathFromRootToNode(root));
    }
}
