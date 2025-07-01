// DFS Traversal for Undirected Graph (Connected + Disconnected)
import java.util.*;
public class Solution {

    // Main method to perform DFS on an undirected graph
    public ArrayList<Integer> dfsUndirected(int A, int[][] B) {
        // Build the graph with undirected edges
        ArrayList<ArrayList<Integer>> graph = buildGraph(A, B, false);
        boolean[] visited = new boolean[A + 1]; // Node indexing starts from 1
        ArrayList<Integer> result = new ArrayList<>();

        // Loop over all nodes to handle disconnected components
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, result);
            }
        }

        return result;
    }

    // Recursive DFS method
    private void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node); // Add to result on first visit

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, result);
            }
        }
    }

    // Build adjacency list for the graph
    private ArrayList<ArrayList<Integer>> buildGraph(int A, int[][] B, boolean directed) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);

            // Add reverse edge for undirected graph
            if (!directed) {
                graph.get(v).add(u);
            }
        }

        return graph;
    }
}

//DFS Traversal for Directed Graph (Connected + Disconnected)

import java.util.*;
public class Solution {

    // Main method to perform DFS on a directed graph
    public ArrayList<Integer> dfsDirected(int A, int[][] B) {
        // Build the graph with directed edges
        ArrayList<ArrayList<Integer>> graph = buildGraph(A, B, true);
        boolean[] visited = new boolean[A + 1];
        ArrayList<Integer> result = new ArrayList<>();

        // Loop over all nodes to cover disconnected components
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, result);
            }
        }

        return result;
    }

    // Reuse DFS and buildGraph method
    private void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, result);
            }
        }
    }

    // Build adjacency list
    private ArrayList<ArrayList<Integer>> buildGraph(int A, int[][] B, boolean directed) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }
       for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v); // Only u → v for directed

            // No reverse edge for directed graph
        }

        return graph;
    }
}

/*Algorithm Steps
1. Build the Graph
Use an adjacency list to store the graph.
For undirected graphs, add both u → v and v → u.
For directed graphs, add only u → v.
2. Prepare Visited Array
Create a boolean array visited[] of size A + 1 (assuming 1-based indexing).
This keeps track of visited nodes.
3. Run DFS on All Nodes
Loop from 1 to A.
If a node i is not visited, start DFS from there.
This handles disconnected components as well.
4. DFS Logic (Recursive)
Mark the current node as visited.
Add it to the result list.
Recursively visit all unvisited neighbors.

Input Format
A – Number of nodes (1-based indexing)
B[][] – List of edges. Each edge is a pair [u, v] */
