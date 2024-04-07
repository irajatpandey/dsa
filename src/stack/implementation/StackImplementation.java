package stack.implementation;

class StackUsingArray{
    int top;
    int capacity;
    int[] stack;
    StackUsingArray(int capacity){
        this.top = -1;
        this.capacity = capacity;
        stack = new int[capacity];
    }

    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == capacity - 1;
    }

    public void push(int element){
        if(isFull()){
            System.out.println("Stack is Full !");
            return;
        }
        stack[++top] = element;
    }
    public void pop(){
        if(isEmpty()){
            return;
        }

        top++;
    }

}
public class StackImplementation {

    public static void main(String[] args) {
        StackUsingArray st = new StackUsingArray(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(30);
        st.push(30);
        st.push(30);
    }
}
