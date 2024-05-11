package binaryTree.hard;

import binaryTree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ChildrenSum {
    public static boolean isSumProperty(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            if(node.left != null && node.right != null) {
                if(node.data != node.left.data + node.right.data){
                    return false;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            else if(node.left != null) {
                if(root.data != node.left.data){
                    return false;
                }
                queue.add(node.left);
            }
            else if(node.right != null) {
                if(node.data != node.right.data){
                    return false;
                }
                queue.add(node.right);
            }
        }
        return true;
    }
    //the time complexity of the traversal is O(N), where N is the number of nodes in the binary tree.
    //Queue: In the worst-case scenario, the queue may hold all the nodes of the last level of the binary tree.
    // Therefore, the space complexity of the queue is O(W), where W is the maximum number of nodes at any level of the binary tree.
    //Worst-case Space: In a complete binary tree, the maximum number of nodes at any level is approximately N/2. Hence, in the worst case,
    // the space complexity of the queue is O(N/2), which simplifies to O(N).
    public static boolean isSumProperty2(TreeNode<Integer> root){
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int leftSum = 0, rightSum = 0;

        if(root.left != null){
            leftSum += root.left.data;
        }
        if(root.right != null){
            rightSum += root.right.data;
        }

        return (root.data == leftSum + rightSum) && isSumProperty2(root.left) && isSumProperty2(root.right);
    }
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(8);
        root.right = new TreeNode<>(2);
        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(5);
        root.right.right = new TreeNode<>(2);

        System.out.println("Is sum property satisfied? " + isSumProperty(root));
        System.out.println("Is sum property satisfied? " + isSumProperty2(root));
    }
}
