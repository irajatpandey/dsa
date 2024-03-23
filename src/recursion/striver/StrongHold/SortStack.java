package recursion.striver.StrongHold;

import java.util.Stack;

public class SortStack {
    public static void insert(Stack<Integer> st, int element){
        if(st.isEmpty() || st.peek() <= element){
            st.push(element);
            return;
        }

        int lastElement = st.pop();
        insert(st, element);

        st.push(lastElement);
    }
    public static void sortStack(Stack<Integer> st){
        if(st.size() == 0) return;

        int element = st.pop();
        sortStack(st);

        insert(st, element);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(2);
        st.push(4);
        st.push(5);
        st.push(1);
        st.push(3);
        System.out.println(st);

        sortStack(st);

        System.out.println(st);

    }
}
