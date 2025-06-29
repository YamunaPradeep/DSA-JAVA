public class Solution {
    public int solve(int[] A, final int B, final int C) {
        int n = A.length;
        
        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 1; i < n; i++) {
            graph.get(A[i]).add(i + 1);
        }

        // Step 2: DFS from C
        boolean[] visited = new boolean[n + 1];
        return dfs(graph, visited, C, B) ? 1 : 0;
    }

    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int current, int target) {
        if (current == target) return true;
        visited[current] = true;

        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                if (dfs(graph, visited, neighbor, target)) return true;
            }
        }

        return false;
    }
}
