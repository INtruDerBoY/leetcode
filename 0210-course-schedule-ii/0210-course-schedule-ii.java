class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // first task is to create graph..
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // create an indegree array for each node...
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses ; i++){
            for(int node : graph.get(i)){
                indegree[node]++;
            }
        }

        // now adding node to q, which have indegree 0...
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }


        // topological sorted array..
        int[] ts = new int[numCourses];
        int i = 0;
        
        while(!q.isEmpty()){
            int node = q.remove();
            ts[i++] = node;

            for(int nbr : graph.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr);
                }
            }

        }
        if(i == 0 || i < numCourses) return new int[]{};
        return ts;
    }
}