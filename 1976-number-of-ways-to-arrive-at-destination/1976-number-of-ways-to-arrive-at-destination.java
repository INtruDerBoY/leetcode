
import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;

        ArrayList<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build an undirected graph
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj[u].add(new int[]{v, time});
            adj[v].add(new int[]{u, time});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new long[]{0, 0}); // distance, node

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();

            long time = curr[0];
            int node = (int) curr[1];

            if (time > dist[node]) {
                continue;
            }

            for (int[] edge : adj[node]) {
                int next = edge[0];
                int travelTime = edge[1];

                long newDist = time + travelTime;

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    ways[next] = ways[node];

                    pq.add(new long[]{newDist, next});
                } else if (newDist == dist[next]) {
                    ways[next] =
                        (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}
