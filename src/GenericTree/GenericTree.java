package GenericTree;

public class GenericTree {
    public static void printTree (TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + ": ");
        for (int i = 0; i < root.children.size(); i++) {
            System.out.print(root.children.get(i).data + ", ");
        }
        System.out.println();
        for (int i = 0; i < root.children.size(); i++) {
            printTree(root.children.get(i));
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(3);

        root.children.add(node1);
        root.children.add(node2);
        printTree(root);

    }
}
