public class Solution {
    public int solve(int A, int[][] B) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=A; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : B){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }

        boolean[] visited = new boolean[A+1];
        boolean[] recStack = new boolean[A+1];

        for(int i=1; i<=A; i++){
            if(!visited[i]){
                if(dfs(i,graph,visited,recStack)){
                    return 1;
                }
            }
        }
        return 0;
    }

    public boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] recStack){
        visited[node] = true;
        recStack[node] =true;

        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                if(dfs(neighbor,graph,visited,recStack)){
                    return true;
                }
            }else if(recStack[neighbor]){
                return true;
            }
        }
        recStack[node] = false;
        return false;
    }
}
