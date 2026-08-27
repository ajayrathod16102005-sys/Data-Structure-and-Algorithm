import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Indegree of each course
        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        // Add courses having no prerequisites
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completed = 0;

        // BFS / Topological Sort
        while (!queue.isEmpty()) {

            int course = queue.poll();
            completed++;

            // Remove this course as a prerequisite
            for (int next : graph.get(course)) {
                indegree[next]--;

                // All prerequisites completed
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If all courses were completed, no cycle exists
        return completed == numCourses;
    }
}