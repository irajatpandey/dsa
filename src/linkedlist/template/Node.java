package linkedlist.template;

public class Node<T>{
    public T data;
    public Node<T> next;
    Node(){

    }
    public Node(T data){
        this.data = data;
        this.next = null;
    }
}
