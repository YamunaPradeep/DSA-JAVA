//undirected graph
public class Solution {
    public int solve(int A, int[][] B, int C, int D) {
        ArrayList<ArrayList<Integer>> graph = buildGraph(A, B, false);
        boolean[] visited = new boolean[A + 1];

        return dfs(C, D, graph, visited) ? 1 : 0;
    }

    private boolean dfs(int current, int target, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        if (current == target) return true;
        visited[current] = true;

        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, target, graph, visited)) return true;
            }
        }

        return false;
    }

    private ArrayList<ArrayList<Integer>> buildGraph(int A, int[][] B, boolean directed) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) graph.add(new ArrayList<>());

        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            if (!directed) graph.get(v).add(u);
        }

        return graph;
    }
}


//You are given a directed graph with A nodes (numbered from 1 to A) and a list of B directed edges.
//You are also given two integers C (source node) and D (destination node). Your task is to determine whether there exists a path from node C to node D following the direction of edges.

public class Solution {
    public int solveDirected(int A, int[][] B, int C, int D) {
        ArrayList<ArrayList<Integer>> graph = buildGraph(A, B, true);  // true for directed
        boolean[] visited = new boolean[A + 1];

        return dfs(C, D, graph, visited) ? 1 : 0;
    }

    private boolean dfs(int current, int target, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
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

    private ArrayList<ArrayList<Integer>> buildGraph(int A, int[][] B, boolean directed) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);  // only u -> v for directed
        }

        return graph;
    }
}


/*✅ Time Complexity
DFS Traversal: O(V + E)
V = number of nodes
E = number of edges
✅ Final space complexity = O(V + E)*/
