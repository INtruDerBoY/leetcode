
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int a = p[0];
            int b = p[1];

            adj.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completed = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            completed++;

            for (int next : adj.get(course)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return completed == numCourses;
    }
}
