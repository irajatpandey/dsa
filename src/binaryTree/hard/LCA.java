package binaryTree.hard;

import binaryTree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
public class LCA {

    public static boolean findPath(TreeNode<Integer> root, int n1, List<TreeNode<Integer>> output){
        if(root == null){
            return false;
        }

        output.add(root);

        if(root.data == n1) return true;

        if(findPath(root.left, n1, output) || findPath(root.right, n1, output)){
            return true;
        }
        output.remove(output.size()-1);
        return false;
    }
    public static TreeNode<Integer> lowestCommonAncestorBruteForce(TreeNode<Integer> root, int n1, int n2){
        if(root == null){
            return null;
        }
        List<TreeNode<Integer>> list1 = new ArrayList<>();
        List<TreeNode<Integer>> list2 = new ArrayList<>();
        if(!findPath(root, n1, list1) || !findPath(root, n2, list2)) {
            return null;
        }

        for(int i = 0; i < list1.size() - 1 && i < list2.size() - 1; i++){
            if(list1.get(i + 1).data != list2.get(i + 1).data){
                return list1.get(i);
            }
        }
        return null;
    }

    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, int n1, int n2){
        if(root == null){
            return null;
        }

        if(root.data == n1 || root.data == n2){
            return root;
        }
        TreeNode<Integer> left = lowestCommonAncestor(root.left, n1, n2);
        TreeNode<Integer> right = lowestCommonAncestor(root.right, n1, n2);

        if(left != null && right != null){
            return root;
        }
        else if(left != null && right == null){
            return left;
        }
        else if(left == null && right != null){
            return right;
        }
        return null;
    }
    public static void main(String[] args) {

        /*
                        3
                       / \
                      5   1
                     / \ / \
                    6  2 0  8
                      / \
                     7   4
        */
        TreeNode<Integer> root = new TreeNode<>(3);
        root.left = new TreeNode<>(5);
        root.right = new TreeNode<>(1);
        root.left.left = new TreeNode<>(6);
        root.left.right = new TreeNode<>(2);
        root.right.left = new TreeNode<>(0);
        root.right.right = new TreeNode<>(8);
        root.left.right.left = new TreeNode<>(7);
        root.left.right.right = new TreeNode<>(4);

        TreeNode<Integer> lca = lowestCommonAncestor(root, 7, 8);
        System.out.println(lca.data);
    }
}
