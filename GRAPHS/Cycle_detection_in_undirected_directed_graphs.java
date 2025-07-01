//CYCLE DETECTION IN UNDIRECTED GRAPH
//🔸 Key Point:
//In an undirected graph, a cycle exists if we revisit a node that is not the parent of the current node during DFS.

//🔹 DFS-Based Algorithm (Java Style):

public class Solution {
    public boolean isCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                if (dfs(nei, node, adj, visited)) return true;
            } else if (nei != parent) {
                return true; // Found a back edge
            }
        }
        return false;
    }
}
//CYCLE DETECTION IN DIRECTED GRAPH
//🔸 Key Point:
//In a directed graph, you need to check for back edges using DFS and recursion stack.

//🔹 DFS-Based Algorithm (Java Style):

public class Solution {
    public boolean isCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                if (dfs(nei, adj, visited, recStack)) return true;
            } else if (recStack[nei]) {
                return true; // Found a back edge
            }
        }

        recStack[node] = false;
        return false;
    }
}



/*Graph Type	Time Complexity	Space Complexity
Undirected	O(V + E)	O(V)
Directed	O(V + E)	O(V)   */
