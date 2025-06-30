//Undirectd graph

public class UndirectedGraph {
    public List<List<Integer>> buildAdjList(int A, int[][] B) {
        List<List<Integer>> adj = new ArrayList<>();

        // Step 1: Initialize empty list for each node
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Add both u → v and v → u for undirected graph
        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u); // reverse direction
        }

        return adj;
    }
}

//Directed graph
public class DirectedGraph {
    public List<List<Integer>> buildAdjList(int A, int[][] B) {
        List<List<Integer>> adj = new ArrayList<>();

        // Step 1: Initialize empty list for each node
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Add only u → v (no reverse)
        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v); // only one direction
        }

        return adj;
    }
}

/*🔷 1. ✅ Adjacency List for Undirected Graph
Key Concept:
In an undirected graph, an edge {u, v} means you can go:
From u to v
And from v to u

So, we add both directions in the adjacency list.

2. ✅ Adjacency List for Directed Graph
Key Concept:
In a directed graph, an edge {u, v} means:
You can go from u to v ONLY
No reverse edge unless explicitly given */


