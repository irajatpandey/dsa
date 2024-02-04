package linkedlist.doublyLL.template;

public class DoublyLinkedListImplementation<T>{
    private Node<T> head = null;
    public boolean isEmpty(){
        return head == null;
    }
    public void addAtBeginning(T data){
        Node dll = new Node(data);
        if(head == null){
            head = dll;
        }
        else{
            dll.next = head;
            head.prev = dll;
            head = dll;
        }
    }
    public void addAtEnd(T data){
        if(isEmpty()){
            head = new Node<>(data);
            return;
        }

        Node<T> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node<>(data);
        temp.next.prev = temp;

    }
    public void addAtPosition(T data, int position){
        Node<T> temp = head;
        for(int i = 1; i < position - 1; i++){
            temp = temp.next;
        }

        Node<T> next = temp.next;

        temp.next = new Node<T>(data);
        temp.next.prev = temp;
        temp.next.next = next;
        next.prev = temp.next;

    }

    public void deleteAtBeginning(){
         if(isEmpty()){
             System.out.println("List is Empty");
             return;
         }

         Node<T> temp = head;
         temp = temp.next;
         temp.prev = null;
         head = temp;

    }
    public void deleteAtEnd(){
        if(isEmpty()){
            System.out.println("List is Empty");
            return;
        }
        Node<T> temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;
    }

    public void deleteAtPosition(Integer position){
        Node<T> temp = head;
        for(int i = 1; i < position - 1; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;
        temp.next.prev = temp;
    }

    public void reverseDoublyLinkedList(){
        Node<T> curr = head;
        Node<T> prev, next;
        prev = next = null;

        while(curr != null){
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            curr = curr.prev;
        }
        head = prev.prev;

    }
    public void swap_nodes(Node<T> node){
        Node<T> prev = node.prev;
        node.prev = node.next;
        node.next = prev;
    }
    private void reverseDoublyLL_recursion(Node<T> curr){
        if(curr.next == null){
            swap_nodes(curr);
            head = curr;
            return;
        }

        swap_nodes(curr);
        reverseDoublyLL_recursion(curr.prev);
    }
    public void reverse(){
        reverseDoublyLL_recursion(head);
    }

    public void printList(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void printReverse(){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        while(temp != head){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.print(temp.data + " ");
        System.out.println();
    }

    public Node getHead(){
        return this.head;
    }

}
