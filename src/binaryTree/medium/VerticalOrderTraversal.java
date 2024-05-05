package binaryTree.medium;

import binaryTree.TreeNode;

import java.util.*;
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
//The time complexity is dominated by the traversal of all nodes (O(N)) and the sorting of nodes within each group (O(N log N) in the worst case).
//The space complexity depends on the number of horizontal distances and levels, as well as the space required for the result. It can be O(N^2) in the worst case but is typically lower in balanced trees.
class PairOfNodeAndHorizontalDistance{
    TreeNode<Integer> node;
    int level;
    int horizontalDistance;

    PairOfNodeAndHorizontalDistance(TreeNode<Integer> node, int level, int horizontalDistance){
        this.node = node;
        this.horizontalDistance = horizontalDistance;
        this.level = level;
    }
}
public class VerticalOrderTraversal {
    public static void printVerticalOrder(Map<Integer, Map<Integer, List<Integer>>> map, Queue<PairOfNodeAndHorizontalDistance> queue){
        while(!queue.isEmpty()){
            PairOfNodeAndHorizontalDistance temp = queue.poll();
            TreeNode<Integer> node = temp.node;
            int horizontalDistance = temp.horizontalDistance;
            int level = temp.level;

            if (!map.containsKey(horizontalDistance)) {
                map.put(horizontalDistance, new TreeMap<>());
            }
            Map<Integer, List<Integer>> levelMap = map.get(horizontalDistance);
            if (!levelMap.containsKey(level)) {
                levelMap.put(level, new ArrayList<>());
            }
            List<Integer> list = levelMap.get(level);
            list.add(node.data);
            levelMap.put(level, list);

            if(temp.node.left != null){
                queue.add(new PairOfNodeAndHorizontalDistance(node.left, level + 1, horizontalDistance - 1));
            }
            if(temp.node.right != null){
                queue.add(new PairOfNodeAndHorizontalDistance(node.right, level + 1, horizontalDistance + 1));
            }
        }
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<PairOfNodeAndHorizontalDistance> queue = new LinkedList<>();
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

        queue.offer(new PairOfNodeAndHorizontalDistance(root, 0, 0));

        printVerticalOrder(map, queue);

        for(int hd : map.keySet()){
            Map<Integer, List<Integer>> levelMap = map.get(hd);
            List<Integer> tempList = new ArrayList<>();
            for (List<Integer> levelList : levelMap.values()) {
                Collections.sort(levelList);
                tempList.addAll(levelList);
            }
            result.add(tempList);
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

        List<List<Integer>> output = verticalTraversal(root);
        System.out.println(output);

    }
}
