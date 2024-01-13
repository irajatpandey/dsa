package linkedlist;
class Node<T>{
    T data;
    Node<T> next;
    Node(){

    }
    Node(T data){
        this.data = data;
        this.next = null;
    }
}
class LinkedListImplementation<T> {
    private Node<T> head;
    LinkedListImplementation(){
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
    public void addAtPosition(T data, Integer position){
        if(position < 0 || position > getSize()){
            System.out.println("Please insert valid position");
            return;
        }
        Node<T> newnode = new Node<>(data);
        Node<T> temp = head;
        for(int i = 1; i < position - 1; i++){
            temp = temp.next;
        }
        Node<T> secondHalf = temp.next;
        temp.next = newnode;
        newnode.next = secondHalf;

    }

    public void deleteAtBeginning(){
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node<T> newHead = head.next;
        head = newHead;
    }
    public void deleteAtEnd(){
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node<T> temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

    }
    public void deleteAtPosition(int position){
        if(position < 0 || position > getSize()){
            System.out.println("Please insert valid position");
            return;
        }
        Node<T> temp = head;
        for(int i = 1; i < position - 1; i++){
            temp = temp.next;
        }

        Node<T> secondHalf = temp.next.next;
        temp.next = secondHalf;
    }

    private Node<T> reverseLL(Node<T> list){
        if(list.next == null || list == null) return list;
        Node<T> smalloutput = reverseLL(list.next);
        System.out.println(list.data);
        list.next.next = list;
        list.next = null;
        return smalloutput;
    }
    private void reverseLL_iterative(Node<T> list){
        Node<T> prev = null, curr = head, next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void reverse_iterative(){
        reverseLL_iterative(head);
    }
    public void reverse_recursive(){
        head = reverseLL(head);
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


public class LinkedList{
    public static void main(String[] args) {
        LinkedListImplementation<Integer> ls = new LinkedListImplementation<>();
        ls.addAtBeginning(50);
        ls.addAtBeginning(40);
        ls.addAtBeginning(30);
        ls.addAtBeginning(20);
        ls.addAtBeginning(10);
        ls.display();
        System.out.println();

        ls.addAtEnd(100);
        ls.addAtEnd(200);
        ls.addAtEnd(300);
        ls.addAtPosition(1000, 3);

        ls.display();

        ls.deleteAtBeginning();
        ls.display();

        ls.deleteAtEnd();
        ls.display();

        ls.deleteAtPosition(4);
        ls.display();
//        ls.reverse_recursive();
//        ls.display();
        ls.reverse_iterative();
        ls.display();




//        LinkedListImplementation<String> s = new LinkedListImplementation<>();
//        s.addAtEnd("a");
//        s.addAtEnd("b");
//        s.addAtEnd("c");
//        s.addAtEnd("d");
//        s.display();

    }
}