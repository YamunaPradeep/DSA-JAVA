// Directed Graph – Adjacency List
//In a directed graph, each edge goes from u to v only, so we add v to the list of u.

public class DirectedGraph {
    public static List<List<Integer>> buildAdjList(int nodes, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= nodes; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);  // Directed edge: u → v
        }

        return adj;
    }

    public static void main(String[] args) {
        int nodes = 4;
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}};

        List<List<Integer>> adjList = buildAdjList(nodes, edges);

        for (int i = 1; i <= nodes; i++) {
            System.out.println("Node " + i + " -> " + adjList.get(i));
        }
    }
}
// 2. Undirected Graph – Adjacency List
//In an undirected graph, each edge connects both ways: u ↔ v, so we add v to u’s list and u to v’s list.

public class UndirectedGraph {
    public static List<List<Integer>> buildAdjList(int nodes, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= nodes; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);  // u → v
            adj.get(v).add(u);  // v → u (because it's undirected)
        }

        return adj;
    }

    public static void main(String[] args) {
        int nodes = 4;
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}};

        List<List<Integer>> adjList = buildAdjList(nodes, edges);

        for (int i = 1; i <= nodes; i++) {
            System.out.println("Node " + i + " -> " + adjList.get(i));
        }
    }
}
