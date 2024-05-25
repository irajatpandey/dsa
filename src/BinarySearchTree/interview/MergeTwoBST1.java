package BinarySearchTree.interview;

import BinarySearchTree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBST1 {

    public static void inorder(BinarySearchTree<Integer> root, List<Integer> inorderOutput) {
        if(root == null) {
            return;
        }
        inorder(root.left, inorderOutput);
        inorderOutput.add(root.data);
        inorder(root.right, inorderOutput);
    }
    public static BinarySearchTree<Integer> mergeTwoBSTs(BinarySearchTree<Integer> tree1, BinarySearchTree<Integer> tree2) {
        List<Integer> inorderOutput1 = new ArrayList<>();
        List<Integer> inorderOutput2 = new ArrayList<>();
        inorder(tree1, inorderOutput1);
        inorder(tree2, inorderOutput2);

        List<Integer> mergedSortedInorderOutput = mergeTwoSortedArray(inorderOutput1, inorderOutput2);

        BinarySearchTree<Integer> root = generateBSTFromInorderTraversal(mergedSortedInorderOutput, 0, mergedSortedInorderOutput.size() - 1);
        return root;
    }

    private static BinarySearchTree<Integer> generateBSTFromInorderTraversal(List<Integer> mergedSortedInorderOutput, int start, int end) {
       if(start > end) {
           return null;
       }

       int mid = start + (end - start) / 2;
       BinarySearchTree<Integer> node = new BinarySearchTree<Integer>(mergedSortedInorderOutput.get(mid));

       node.left = generateBSTFromInorderTraversal(mergedSortedInorderOutput, start, mid - 1);
       node.right = generateBSTFromInorderTraversal(mergedSortedInorderOutput, mid + 1, end);

       return node;
    }

    private static List<Integer> mergeTwoSortedArray(List<Integer> inorderOutput1, List<Integer> inorderOutput2) {
        List<Integer> mergedSortedInorderOutput = new ArrayList<>();
        int m = inorderOutput1.size();
        int n = inorderOutput2.size();
        int i = 0, j = 0;

        while(i < m && j < n) {
            if(inorderOutput1.get(i) < inorderOutput2.get(j)) {
                mergedSortedInorderOutput.add(inorderOutput1.get(i));
                i++;
            }
            else{
                mergedSortedInorderOutput.add(inorderOutput2.get(j));
                j++;
            }
        }
        while(i < m) {
            mergedSortedInorderOutput.add(inorderOutput1.get(i));
            i++;
        }
        while(j < n) {
            mergedSortedInorderOutput.add(inorderOutput2.get(j));
            j++;
        }

        return mergedSortedInorderOutput;
    }


    public static void main(String[] args) {
        // Create first BST
        // Tree structure:
        //      10
        //     /  \
        //    5   15
        //   / \    \
        //  3   7    18
        BinarySearchTree<Integer> root1 = new BinarySearchTree<>(10);
        root1.left = new BinarySearchTree<>(5);
        root1.right = new BinarySearchTree<>(15);
        root1.left.left = new BinarySearchTree<>(3);
        root1.left.right = new BinarySearchTree<>(7);
        root1.right.right = new BinarySearchTree<>(18);

        // Create second BST
        // Tree structure:
        //      20
        //     /  \
        //    16  25
        //   /   /  \
        //  12  23  30
        BinarySearchTree<Integer> root2 = new BinarySearchTree<>(20);
        root2.left = new BinarySearchTree<>(16);
        root2.right = new BinarySearchTree<>(25);
        root2.left.left = new BinarySearchTree<>(12);
        root2.right.left = new BinarySearchTree<>(23);
        root2.right.right = new BinarySearchTree<>(30);

        // Merge the BSTs
        BinarySearchTree<Integer> mergedRoot = mergeTwoBSTs(root1, root2);

        // Function to print inorder traversal of the merged BST
        List<Integer> mergedList = new ArrayList<>();
        inorder(mergedRoot, mergedList);
        System.out.println("Inorder traversal of the merged BST: " + mergedList);

    }
}
