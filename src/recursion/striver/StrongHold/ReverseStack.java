package recursion.striver.StrongHold;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseStack {

    public static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()) return;

        int element = st.pop();


        reverseStack(st);

    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.add(1);
        st.add(2);
        st.add(3);
        st.add(4);
        st.add(5);

        System.out.println(st);

        reverseStack(st);

        System.out.println(st.peek());


    }
}
