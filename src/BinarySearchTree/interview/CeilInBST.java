package BinarySearchTree.interview;

import BinarySearchTree.BinarySearchTree;
//the time complexity to find the ceil in a Binary Search Tree (BST) is O(h), where h is the height of the tree.
public class CeilInBST {
    public static int ceil(BinarySearchTree<Integer> root, int key) {
        if(root == null) {
            return -1;
        }

        BinarySearchTree<Integer> current = root;
        int ceilValue = Integer.MAX_VALUE;
        while(current != null) {
            if(current.data == key) {
                return current.data;
            }
            else if(current.data < key){
                current = current.right;
            }
            else{
                ceilValue = current.data;
                current = current.left;
            }
        }
        return ceilValue == Integer.MAX_VALUE ? -1 : ceilValue;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> root = new BinarySearchTree<>(8);
        root.left = new BinarySearchTree<>(4);
        root.right = new BinarySearchTree<>(12);
        root.left.left = new BinarySearchTree<>(2);
        root.left.right = new BinarySearchTree<>(6);
        root.right.left = new BinarySearchTree<>(10);
        root.right.right = new BinarySearchTree<>(14);

        int key = 5;
        int ceilValue = ceil(root, key);
        System.out.println("Ceil of " + key + " in the BST is: " + ceilValue);
    }
}
