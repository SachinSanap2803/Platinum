package Graph;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Keep track of in-degrees
        int[] indegree = new int[numCourses];

        // Fill graph and indegree array
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Queue for courses that have no prerequisites
        Queue<Integer> queue = new LinkedList<>();

        // Add all courses with indegree 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0; // count of courses that can be taken

        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If we were able to take all courses, return true
        return count == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(cs.canFinish(numCourses1, prerequisites1)); // true

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(cs.canFinish(numCourses2, prerequisites2)); // false
    }
}