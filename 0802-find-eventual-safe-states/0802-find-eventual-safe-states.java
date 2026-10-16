class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];
        List<Integer> safe = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(state,graph,i)) {
                safe.add(i);
            }
        }

        return safe;
    }


private boolean dfs(int[] state, int[][] graph, int node) {
    if (state[node] == 1) return false;
    if (state[node] == 2) return true;

    state[node] = 1;

    for (int ne : graph[node]) {
        if (!dfs(state, graph, ne)) {
            return false;
        }
    }

    state[node] = 2;
    return true;
}

}
