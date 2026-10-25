import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] effort = new int[m][n];

        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        effort[0][0] = 0;
        pq.add(new int[]{0, 0, 0}); // effort, row, column

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int currEffort = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == m - 1 && c == n - 1) {
                return currEffort;
            }

            if (currEffort > effort[r][c]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n) {

                    int diff = Math.abs(
                        heights[r][c] - heights[nr][nc]
                    );

                    int newEffort = Math.max(currEffort, diff);

                    if (newEffort < effort[nr][nc]) {
                        effort[nr][nc] = newEffort;
                        pq.add(new int[]{newEffort, nr, nc});
                    }
                }
            }
        }

        return 0;
    }
}