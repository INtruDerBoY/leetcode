class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int components = n;

        for (int[] conn : connections) {
            int a = find(conn[0], parent);
            int b = find(conn[1], parent);
            if (a != b) {
                parent[a] = b;
                components--;
            }
        }

        return components - 1;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x)
            parent[x] = find(parent[x], parent);  // Path compression
        return parent[x];
    }
}
