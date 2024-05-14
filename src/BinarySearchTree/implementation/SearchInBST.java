package BinarySearchTree.implementation;

import BinarySearchTree.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
/*
* Time and Space Complexity
* Best case: O(log n)
`Average case: O(log n);
 Worst case: O(n)
 Space Complexity
 * Best case and average case (balanced tree): O(log n) due to the maximum depth of the recursive call stack.
Worst case (skewed tree): O(n) due to the maximum depth of the recursive call stack.
https://leetcode.com/problems/search-in-a-binary-search-tree/
* */
public class SearchInBST {

    // Recursive Method to find the element in BST
    public static BinarySearchTree<Integer> search(BinarySearchTree<Integer> root, int item){
       if(root == null || root.data == item){
           return root;
       }
       if(root.data > item){
           return search(root.left, item);
       }
       else{
           return search(root.right, item);
       }
    }

    public static BinarySearchTree<Integer> serachInBST_Iterative(BinarySearchTree<Integer> root, int item){
        if(root == null || root.data == item){
            return root;
        }

        Queue<BinarySearchTree<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinarySearchTree<Integer> current = queue.remove();
            if(current.data == item){
                return current;
            }
            if(current.data > item){
                queue.add(current.left);
            }
            else{
                queue.add(current.right);
            }
        }
        return null;
    }
    public static void main(String[] args) {

        BinarySearchTree<Integer> root = new BinarySearchTree<>(2);
        // Manually set child nodes
        root.left = new BinarySearchTree<>(1);
        root.right = new BinarySearchTree<>(5);

        // Further build the BST manually
        root.left.left = new BinarySearchTree<>(0);
        root.left.right = new BinarySearchTree<>(3);
        root.right.left = new BinarySearchTree<>(4);
        root.right.right = new BinarySearchTree<>(6);

        BinarySearchTree<Integer> output = search(root, 5);
        System.out.println(output.data);

        BinarySearchTree<Integer> output2 = serachInBST_Iterative(root, 5);
        System.out.println(output2.data);
    }
}
