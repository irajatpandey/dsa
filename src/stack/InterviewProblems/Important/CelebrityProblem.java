package stack.InterviewProblems.Important;

import java.util.Stack;

public class CelebrityProblem {
    public static int findCelebrityBruteForce(int N, int[][] M) {
        for (int i = 0; i < N; i++) {
            boolean isCelebrity = true;
            for (int j = 0; j < N; j++) {
                // Skip checking if the person knows themselves
                if (i == j) continue;

                // If person i knows anyone or if anyone doesn't know person i, i cannot be a celebrity
                if (M[i][j] == 1 || M[j][i] == 0) {
                    isCelebrity = false;
                    break;
                }
            }
            if (isCelebrity) return i;
        }
        // If no celebrity is found, return -1
        return -1;
    }

    //The overall time complexity of the solution is O(N) + O(N) + O(N) = O(N).
    //the space complexity is O(N) for the stack.
    public static int findCelebrity(int N, int[][] M) {
        Stack<Integer> stack = new Stack<>();

        // Push all people onto the stack
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int person2 = stack.pop();
            int person1 = stack.pop();

            // If person1 knows person2, person1 cannot be a celebrity, so discard person1
            if (M[person1][person2] == 1) {
                stack.push(person2);
            } else {
                // If person1 doesn't know person2, person2 cannot be a celebrity, so discard person2
                stack.push(person1);
            }
        }

        int celebrityCandidate = stack.pop();

        // Check if the candidate is known by everyone and if they know no one else
        for (int i = 0; i < N; i++) {
            if (i != celebrityCandidate && (M[celebrityCandidate][i] == 1 || M[i][celebrityCandidate] == 0)) {
                return -1;
            }
        }

        return celebrityCandidate;
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] M = {{0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}};

        System.out.println(findCelebrity(N, M));  // Output: 1
    }
}
