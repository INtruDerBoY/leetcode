
import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Create adjacency list
        ArrayList<int[]>[] adj = new ArrayList[n+1];

        for (int i = 0; i <=n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj[u].add(new int[]{v, wt});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int d = curr[0];
            int node = curr[1];
            if (d > dist[node]) {
                continue;
            }

            for (int[] edge : adj[node]) {
                int next = edge[0];
                int wt = edge[1];

                if (d + wt < dist[next]) {
                    dist[next] = d + wt;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}
