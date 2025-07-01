//CYCLE DETECTION IN UNDIRECTED GRAPH
//🔸 Key Point:
//In an undirected graph, a cycle exists if we revisit a node that is not the parent of the current node during DFS.

//🔹 DFS-Based Algorithm (Java Style):

✅ Cycle Detection in an Undirected Graph (Using DFS)
java
Copy
Edit
public class Solution {
    public boolean isCycle(int n, int[][] edges) {
        // Step 1: Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        // Since it's undirected, add both u->v and v->u
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Step 2: Keep track of visited nodes
        boolean[] visited = new boolean[n];

        // Step 3: DFS from every unvisited node (handle disconnected components)
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited)) return true; // Cycle found
            }
        }

        return false; // No cycle in any component
    }

    // DFS function with parent tracking
    private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                if (dfs(nei, node, adj, visited)) return true;
            } else if (nei != parent) {
                // If the neighbor is visited and not parent, it's a cycle
                return true;
            }
        }

        return false;
    }
}
✅ Cycle Detection in a Directed Graph (Using DFS + Recursion Stack)
java
Copy
Edit
public class Solution {
    public boolean isCycle(int n, int[][] edges) {
        // Step 1: Build the adjacency list (directed)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]); // Only from u -> v
        }

        // Step 2: Track visited nodes and recursion stack
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];

        // Step 3: DFS for every unvisited node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack)) return true; // Cycle found
            }
        }

        return false; // No cycle
    }

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true; // Mark node in current recursion path

        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                if (dfs(nei, adj, visited, recStack)) return true;
            } else if (recStack[nei]) {
                // Found a back edge -> cycle
                return true;
            }
        }

        recStack[node] = false; // Backtrack
        return false;
    }
}

/*Graph Type	Time Complexity	Space Complexity
Undirected	O(V + E)	O(V)
Directed	O(V + E)	O(V)   */
