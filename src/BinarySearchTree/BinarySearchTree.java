package BinarySearchTree;

public class BinarySearchTree<T> {
    public T data;
    public BinarySearchTree<T> left;
    public BinarySearchTree<T> right;

    public BinarySearchTree(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


