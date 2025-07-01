//Given a directed graph with A nodes (labeled from 1 to A), and a list of edges B[][], determine if there is a path from node 1 to node A.
/*Build the graph using an adjacency list from the edge list B.
Since the graph is directed, add only u → v (not v → u).
Initialize a visited array to track visited nodes and prevent infinite loops.
Run DFS starting from node 1.
If during DFS, you reach node A, return true.
If DFS completes without reaching A, return false.
Return 1 if path exists, else return 0*/

public class Solution {
    public int solve(int A, int[][] B) {
        // Step 1: Build adjacency list for directed graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v); // Directed edge
        }

        // Step 2: DFS to check if path from 1 to A exists
        boolean[] visited = new boolean[A + 1];
        return dfs(1, A, graph, visited) ? 1 : 0;
    }

    // DFS function
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

/*Path in Directed Graph – DFS Approach
Goal
Check if there is a path from node 1 to node A in a directed graph.
✅ Algorithm
Build the adjacency list.
Use a boolean visited[] array.
Run DFS from node 1.
If DFS reaches node A, return 1.
Else, return 0. */
