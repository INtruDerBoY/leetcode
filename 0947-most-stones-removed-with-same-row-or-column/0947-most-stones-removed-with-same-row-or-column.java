class Solution {
    public void dfs(int src,List<List<Integer>> adjust,boolean visited[]){
        visited[src]=true;
        for(int neighbour:adjust.get(src)){
            if(!visited[neighbour]){
                dfs(neighbour,adjust,visited);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n= stones.length;
        List<List<Integer>> adjust = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjust.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1]){
                    adjust.get(i).add(j);
                    adjust.get(j).add(i);
                }
            }
        }
        int component=0;
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,adjust,visited);
                component++;
            }
        }
        return n-component;
    }
}