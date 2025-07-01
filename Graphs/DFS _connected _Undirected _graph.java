public class DFS_Traversal_ConnectedGraph {
  public static void main(String[] args) {
        // Number of nodes
        int N = 5;

        // Edge list of undirected graph
        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 3},
            {2, 4}
        };

        // Step 1: Build adjacency list from edges
        List<List<Integer>> graph = buildAdjList(N, edges);

        // Step 2: Track visited nodes
        boolean[] visited = new boolean[N];

        // Step 3: Run DFS starting from node 0
        System.out.print("DFS Traversal: ");
        dfs(0, graph, visited);
    }

    // Build adjacency list from edge list
    public static List<List<Integer>> buildAdjList(int N, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // Undirected edge
        }

        return adj;
    }

    // DFS function: recursive traversal
    public static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}


//For connected graphs, a single DFS from any node visits all nodes.
//For disconnected graphs, you need to run DFS on all unvisited nodes to cover all components.

/*Algorithm Steps
Build the Graph
Use an adjacency list to represent the graph.
For each edge [u, v], add v to u's list and u to v's list (undirected).
Initialize Visited Array
Create a boolean array visited[] of size N.
Initially mark all nodes as false.
Start DFS from Node 0
Call the dfs(0) function.
DFS Function
Mark the current node as visited.
Print the current node.
Recursively call DFS for all unvisited neighbors of the current node. */

