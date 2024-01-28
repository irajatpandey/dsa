package linkedlist.template;

public class LinkedListImplementation<T> {
    private Node<T> head;
    public LinkedListImplementation(){
        this.head = null;
    }
    private int getSize(){
        Node<T> temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public Node getHead(){
        return this.head;
    }
    private boolean isEmpty(){
        return head == null;
    }
    public void addAtBeginning(T data){
        Node<T> newnode = new Node<>(data);
        if(isEmpty()){
            head = newnode;
            return;
        }
        else{
            newnode.next = head;
            head = newnode;
        }
    }
    public void addAtEnd(T data){
        Node<T> newnode = new Node<>(data);
        if(isEmpty()){
            head = newnode;
        }
        else{
            Node<T> temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newnode;
        }
    }



    public void display(){
        Node<T> temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

