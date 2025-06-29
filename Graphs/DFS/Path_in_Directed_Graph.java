public class Solution {
    public int solve(int A, int[][] B) {
        // Step 1: Build the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }

        // Step 2: DFS to check if path from 1 to A exists
        boolean[] visited = new boolean[A + 1];
        return dfs(1, A, graph, visited) ? 1 : 0;
    }

    private boolean dfs(int current, int target, List<List<Integer>> graph, boolean[] visited) {
        if (current == target) return true;

        visited[current] = true;

        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, target, graph, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
