package stack.implementation;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue{
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public int getSize(){
        return q1.size();
    }
    public void push(int element){
        q2.add(element);
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        Queue<Integer> q3 = q1;
        q1 = q2;
        q2 = q3;

    }
    public int top(){
        return (int) q1.peek();
    }
    public int pop(){
        if(q1.isEmpty()) return -1;
        return q1.remove();
    }
}
public class StackQueueImplementation {
    public static void main(String[] args) {
        StackUsingQueue st = new StackUsingQueue();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        System.out.println(st.top());
        System.out.println(st.pop());
    }


}
