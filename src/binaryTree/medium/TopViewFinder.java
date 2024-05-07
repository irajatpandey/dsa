package binaryTree.medium;

import binaryTree.TreeNode;

//Time Complexity
//O(n * log(n)), Where 'n' is the number of nodes in the given binary tree.
//
//Since we are traversing at every node and storing the horizontal distance of every node into Map, inserting an element into the map will take O(log n) time. In the worst case (Skewed Trees),
// there will be 'n' distinct horizontal distance, so it will take O(n * log(n)).
// While for the 'n' element, push and pop operation take O(1) time for the queue and also inserting and searching into the list take O(1) time.
// So overall time complexity will be O(n * log(n)).
//
//Space Complexity
//O(n), Where 'n' is the number of nodes in the given binary tree.
//Since we are storing the top view of the tree, so in the worst case (Skewed Trees), all nodes of the given tree will be the top view elements so,
// there will be 'n' distinct horizontal distance to be stored and also in that case stack size for recursion will be O(n).
// So overall space complexity will be O(n).
import java.util.*;
class Pair2{
    int level;
    int data;
    public Pair2(int level, int data){
        this.level = level;
        this.data = data;
    }
}
public class TopViewFinder {
    public static void printTopView(TreeNode<Integer> root, Map<Integer, Pair2> mp, int horizontalDistance, int level) {
        if(root == null) return;

        if(!mp.containsKey(horizontalDistance) || mp.get(horizontalDistance).level > level) {
            mp.put(horizontalDistance, new Pair2(level, root.data));
        }
        printTopView(root.left, mp, horizontalDistance - 1, level + 1);
        printTopView(root.right, mp, horizontalDistance + 1, level + 1);
    }
    public static List<Integer> findTopView(TreeNode<Integer> root){
        List<Integer> result = new ArrayList<>();
        Map<Integer, Pair2> mp = new TreeMap<>();
        printTopView(root, mp, 0, 0);

        for(Pair2 pair : mp.values()) {
            result.add(pair.data);
        }
        return result;
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

        List<Integer> topView = findTopView(root);
        System.out.println(topView);
    }
}
