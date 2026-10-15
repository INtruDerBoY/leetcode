class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] p: prerequisites){
            adj[p[0]].add(p[1]);
        }
        int[] visited = new int[numCourses];
        for(int i =0;i<numCourses;i++){
            if(visited[i]==0){
                if(dfs(i,adj,visited)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int node, ArrayList<Integer>[] adj, int[] visited){
        visited[node]=1;
        for(int n:adj[node]){
            if(visited[n]==1){
                return true;
            }
            if(visited[n]==0){
                if(dfs(n,adj,visited)){
                return true;
            }
            }
        }
       visited[node]=2;
        return false;
       
    }

}