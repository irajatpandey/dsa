package binaryTree.traversal;

import binaryTree.TreeNode;

import java.util.Stack;

public class PostOrderIterative {
    public static void postOrderIterativeUsingTwoStack(TreeNode<Integer> root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode<Integer>> stack1 = new Stack<>();
        Stack<TreeNode<Integer>> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode<Integer> temp = stack1.pop();
            stack2.push(temp);
            if(temp.left != null) {
                stack1.push(temp.left);
            }
            if(temp.right != null) {
                stack1.push(temp.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }
    //Time & Space Complexity: The time complexity of this algorithm is O(n),
    public static void postOrderIterativeUsingSingleStack(TreeNode<Integer> root) {
        if (root == null) return;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> prev = null; // Track the previously visited node

        while (root != null || !stack.isEmpty()) { // Start traversal loop

            // Step 1: Traverse left subtree until leftmost node is reached
            while (root != null) {
                stack.push(root); // Push node onto stack
                root = root.left; // Move to the left child
            }

            // Step 2: Check if current node has a right child or if it has been visited
            TreeNode<Integer> peek = stack.peek(); // Get the top node on stack
            if (peek.right == null || peek.right == prev) {
                // If no right child or right child is already visited, visit current node
                System.out.print(peek.data + " ");
                prev = stack.pop(); // Mark current node as visited and pop it from stack
            } else {
                // Step 3: If right child exists and is unvisited, move to the right subtree
                root = peek.right; // Move to the right child
            }
        }
    }
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);
        // 4  5  2  6  3  1
        System.out.println("Postorder traversal of binary tree is: ");
        postOrderIterativeUsingTwoStack(root);
        System.out.println("\nUsing Single Stack");
        postOrderIterativeUsingSingleStack(root);
    }
}
