package BinarySearchTree.interview;

import BinarySearchTree.BinarySearchTree;

public class KthSmallestAndLargestInBST {

    static int count = 0;
    static int ans = -1;
    static int count2 = 0;
    static int output = -1;

    public static void kthSmallestHelper(BinarySearchTree<Integer> root, int k){
        if(root == null) return;

        kthSmallestHelper(root.left, k);
        count++;
        if(k == count){
            ans = root.data;
            return;
        }
        kthSmallestHelper(root.right, k);
    }

    public static void kthLargestHelper(BinarySearchTree<Integer> root, int k){
        if(root == null) return;


        if(root.right != null) {
            kthLargestHelper(root.right, k);
        }
        count2++;
        if(count2 == k){
            output = root.data;
            return;
        }
        if(root.left != null) {
            kthLargestHelper(root.left, k);
        }
    }

    public static int kthLargest(BinarySearchTree<Integer> root, int k){
        kthLargestHelper(root, k);
        return output;
    }
    public static int kthSmallest(BinarySearchTree<Integer> root, int k) {
        kthSmallestHelper(root, k);
        return ans;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> root = new BinarySearchTree<>(5);
        root.left = new BinarySearchTree<>(2);
        root.left.right = new BinarySearchTree<>(4);
        root.left.right.left = new BinarySearchTree<>(3);

        int k = 4; // Finding the 4th smallest element
        System.out.println("The " + k + "th smallest element is: " + kthSmallest(root, k));
        System.out.println("The " + k + "th largest element is: " + kthLargest(root, k));

    }
}
