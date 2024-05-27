package heap.interview_problems;

import java.util.*;
//https://leetcode.com/problems/task-scheduler/description/
public class TaskScheduler {

    /**
     * Finds the minimum intervals required to complete all tasks.
     *
     * @param tasks an array of characters representing different tasks
     * @param n     the cooldown period between two tasks of the same type
     * @return      the minimum number of intervals required to complete all tasks
     *
     * Time Complexity: O(n log k), where n is the number of unique tasks and k is 26 characters.
     * Space Complexity: O(26) = O(1)
     */
    public static int leastInterval(char[] tasks, int n) {
        // Map to store the frequency of each task
        Map<Character, Integer> taskFrequencyMap = new HashMap<>();
        for (char task : tasks) {
            taskFrequencyMap.put(task, taskFrequencyMap.getOrDefault(task, 0) + 1);
        }

        // Priority queue to order tasks by frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> (e2.getValue() - e1.getValue()));
        maxHeap.addAll(taskFrequencyMap.entrySet());

        int minInterval = 0;
        while (!maxHeap.isEmpty()) {
            int cooldown = n + 1;
            Queue<Map.Entry<Character, Integer>> cooldownQueue = new LinkedList<>();

            // Execute tasks with cooldown
            while (!maxHeap.isEmpty() && cooldown > 0) {
                Map.Entry<Character, Integer> taskEntry = maxHeap.poll();
                if (taskEntry.getValue() > 1) {
                    taskEntry.setValue(taskEntry.getValue() - 1);
                    cooldownQueue.add(taskEntry);
                }
                minInterval++;
                cooldown--;
            }

            // Add tasks back to the queue if they are still pending
            if (!cooldownQueue.isEmpty()) {
                maxHeap.addAll(cooldownQueue);
                minInterval += cooldown;
            }
        }

        return minInterval;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
}