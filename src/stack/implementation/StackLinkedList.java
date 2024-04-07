package stack.implementation;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}

class LinkedList{
    Node head;
    LinkedList(){
        head = null;
    }
    public int size(){
        Node temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    private void insertAtBeginning(int element){
        Node n1 = new Node(element);
        n1.next = head;
        head = n1;
    }
    private boolean isEmpty(){
        return head == null;
    }
    public void push(int ele){
        insertAtBeginning(ele);
    }
    public int pop(){
        int output = head.data;
        deleteAtBeginning();
        return output;
    }
    public int top(){
        if(isEmpty()){
            return -1;
        }
        return head.data;
    }
    private void insertAtEnd(int element){
        Node n1 = new Node(element);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(element);
    }
    private void deleteAtBeginning(){
        if(isEmpty()){
            return;
        }
        Node temp = head;
        temp = temp.next;
        head = temp;

    }

}
public class StackLinkedList {
    public static void main(String[] args) {
        LinkedList st = new LinkedList();
        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println(st.size() + " " + st.top());

        st.push(40);
        System.out.println(st.size() + " " + st.top());
        System.out.println(st.pop());
        System.out.println(st.size() + " " + st.top());

    }
}
