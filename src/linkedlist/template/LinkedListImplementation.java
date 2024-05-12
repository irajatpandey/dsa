package linkedlist.template;

public class LinkedListImplementation<T> {
    private Node<T> head;

    // Constructor to initialize the linked list with a null head
    public LinkedListImplementation() {
        this.head = null;
    }

    // Method to get the size of the linked list
    private int getSize() {
        Node<T> temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Method to get the head of the linked list
    public Node<T> getHead() {
        return this.head;
    }

    // Method to check if the linked list is empty
    private boolean isEmpty() {
        return head == null;
    }

    // Method to add a node at the beginning of the linked list
    public void addAtBeginning(T data) {
        Node<T> newnode = new Node<>(data);
        if (isEmpty()) {
            head = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
    }

    // Method to add a node at the end of the linked list
    public void addAtEnd(T data) {
        Node<T> newnode = new Node<>(data);
        if (isEmpty()) {
            head = newnode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
        }
    }

    // Method to display the elements of the linked list
    public void display() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
