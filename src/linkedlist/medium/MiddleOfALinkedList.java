package linkedlist.medium;
import linkedlist.template.LinkedListImplementation;
public class MiddleOfALinkedList {
    public static void main(String[] args) {
        LinkedListImplementation<Integer> ls = new LinkedListImplementation<>();
        int arr[] = {10, 20, 30, 40, 50};
        for(int ele : arr){
            ls.addAtEnd(ele);
        }

        ls.display();
    }
}
