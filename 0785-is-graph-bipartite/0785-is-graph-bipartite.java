class Solution {
    public boolean isBipartite(int[][] graph) {
        int ne = graph.length;
        int[] color=new int[ne];
        for(int i=0;i<ne;i++){
            if(color[i]==0){
            Queue<Integer> q= new LinkedList<>();
            q.offer(i);
            color[i]=1;
            while(!q.isEmpty()){
                int node=q.poll();
                for(int n:graph[node]){
                    if(color[n]==0){
                        color[n]=-color[node];
                        q.offer(n);
                    }
                else if(color[n]==color[node]){
                    return false;
                }
                }
            }
            }
        }
        return true;
    }
}