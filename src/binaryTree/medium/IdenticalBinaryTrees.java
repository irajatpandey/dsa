package binaryTree.medium;

import binaryTree.TreeNode;
//https://leetcode.com/problems/same-tree/description/
// Time Complexity: O(n)
public class IdenticalBinaryTrees {
    public static boolean areIdenticalTrees(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 == null || root2 == null){
            return false;
        }

        boolean isSameLeft = areIdenticalTrees(root1.left, root2.left);
        boolean isSameRight = areIdenticalTrees(root1.right, root2.right);

        return isSameLeft && isSameRight;
    }
    public static void main(String[] args) {

    }
}
