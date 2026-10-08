class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int cnt = 0;

     
        for (int node = 0; node < visited.length; node++) {
         
            if (!visited[node]) {
                cnt++;
                dfs(node, isConnected, visited);
            }
        }

        return cnt;
    }
        
        public void dfs(int node, int[][] isConnected, boolean[] visited) {
        visited[node] = true; 
        for (int neighbour = 0; neighbour < visited.length; neighbour++) {  
            if (isConnected[node][neighbour] == 1 && !visited[neighbour]) {
                dfs(neighbour, isConnected, visited);
            }
        }
        
    }
}