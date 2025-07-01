//DFS for Disconnectd undirectdd graph
public class DFS_Disconnected_Undirected {
    public static void main(String[] args) {
        int N = 6;
        int[][] edges = {
            {0, 1},
            {0, 2},
            {3, 4}
            // Node 5 is isolated
        };

        List<List<Integer>> graph = buildAdjList(N, edges);
        boolean[] visited = new boolean[N];

        System.out.print("DFS Traversal (Undirected, Disconnected): ");
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
            }
        }
    }

    public static List<List<Integer>> buildAdjList(int N, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);  // undirected
        }
        return adj;
    }

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

//DFS traversl for Disconnected directd graph
public class DFS_Disconnected_Directed {
    public static void main(String[] args) {
        int N = 6;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {3, 4}
            // Node 5 is isolated
        };

        List<List<Integer>> graph = buildAdjList(N, edges);
        boolean[] visited = new boolean[N];

        System.out.print("DFS Traversal (Directed, Disconnected): ");
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
            }
        }
    }

    public static List<List<Integer>> buildAdjList(int N, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);  // directed
        }
        return adj;
    }

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


/*✅ Algorithm
Build adjacency list from edges.

Create a visited[] array.

Loop from i = 0 to N-1:

If visited[i] == false, call DFS(i) */
