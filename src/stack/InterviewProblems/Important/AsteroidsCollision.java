package stack.InterviewProblems.Important;

import java.util.Stack;
//https://leetcode.com/problems/asteroid-collision/description/
//This solution has a time complexity of O(n), where n is the number of asteroids in the input array,
// because we iterate through the array only once. It also has a space complexity of O(n) due to the stack usage.
public class AsteroidsCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        st.push(asteroids[0]);
        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] > 0){
                st.push(asteroids[i]);
            }
            else{
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == Math.abs(asteroids[i])){
                    st.pop();
                }
                else if(!st.isEmpty() && st.peek() > 0 && st.peek() > Math.abs(asteroids[i])){
                    continue;
                }
                else{
                    st.push(asteroids[i]);
                }
            }

        }
        int k = st.size() - 1;
        int[] ans = new int[st.size()];
        while(st.size() > 0){
            ans[k--] = st.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ans = asteroidCollision(new int[]{-2, -2, 1, -1});
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
