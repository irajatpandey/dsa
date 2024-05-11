package binaryTree.hard;

import binaryTree.TreeNode;

import java.util.*;
/*
1. getParents method:

This method traverses the entire binary tree once to build a mapping of each node to its parent.
It uses a level-order traversal (BFS) technique.
Time complexity: O(N), where N is the number of nodes in the binary tree.

2. findNodesAtDistanceK method:
It performs a BFS traversal starting from the target node to find all nodes at distance K.
In the worst case, it may visit all nodes of the binary tree.
The while loop iterates over all nodes at each level up to distance K.
Each node is processed once.
So, the overall time complexity is O(N), where N is the number of nodes in the binary tree.

* */

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class AllNodesDistanceKFinder {

    public static void getParents(TreeNode<Integer> root, Map<TreeNode<Integer>, TreeNode<Integer>> map, TreeNode<Integer> target){
        if(root == null) return;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode<Integer> node = queue.poll();
            if(node.left != null) {
                map.put(node.left, node);
                queue.offer(node.left);
            }
            if(node.right != null) {
                map.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }
    public static List<Integer> findNodesAtDistanceK(TreeNode<Integer> root, TreeNode<Integer> target, int k) {
        List<Integer> output = new ArrayList<>();
        Map<TreeNode<Integer>, TreeNode<Integer>> map = new HashMap<>();
        getParents(root, map, target);

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        Map<TreeNode<Integer>, Boolean> visited = new HashMap<>();
        queue.add(target);
        visited.put(target, true);
        int currentLevel = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(currentLevel == k) {
                break;
            }
            currentLevel++;
            for(int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                if (node.left != null && visited.get(node.left) == null) {
                    queue.offer(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && visited.get(node.right) == null) {
                    queue.offer(node.right);
                    visited.put(node.right, true);
                }
                if(map.get(node) != null && visited.get(map.get(node)) == null) {
                    queue.offer(map.get(node));
                    visited.put(map.get(node), true);
                }
            }
        }


        while(!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            output.add(node.data);
        }
        return output;
    }



    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(3);
        root.left = new TreeNode<>(5);
        root.right = new TreeNode<>(1);
        root.left.left = new TreeNode<>(6);
        root.left.right = new TreeNode<>(2);
        root.left.right.left = new TreeNode<>(7);
        root.left.right.right = new TreeNode<>(4);
        root.right.left = new TreeNode<>(0);
        root.right.right = new TreeNode<>(8);

        List<Integer> output = findNodesAtDistanceK(root, root.left, 2);
        System.out.println(output);


    }
}
