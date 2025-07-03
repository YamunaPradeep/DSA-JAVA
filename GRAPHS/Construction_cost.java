public class Solution {
    static final int MOD = 1000000007;

    class Pair {
        int node, cost;
        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int solve(int A, int[][] B) {
        // Step 1: Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : B) {
            int u = edge[0] - 1;  // 0-based indexing
            int v = edge[1] - 1;
            int cost = edge[2];
            adj.get(u).add(new Pair(v, cost));
            adj.get(v).add(new Pair(u, cost));
        }

        // Step 2: Prim's algorithm
        boolean[] visited = new boolean[A];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Pair(0, 0));  // start from node 0 (which is node 1 in 1-based index)

        long totalCost = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int cost = current.cost;

            if (visited[node]) continue;

            visited[node] = true;
            totalCost = (totalCost + cost) % MOD;

            for (Pair neighbor : adj.get(node)) {
                if (!visited[neighbor.node]) {
                    pq.add(new Pair(neighbor.node, neighbor.cost));
                }
            }
        }

        // Final check: did we visit all nodes?
        for (boolean v : visited) {
            if (!v) return -1;
        }

        return (int) totalCost;
    }
}


/*We start from node 0 (which is node 1 in the input).
We use a min-heap to always pick the edge with the smallest cost.
For each node visited, we add its neighbors to the heap.
We add up the costs of edges used to build the MST. */

/*This can be solved using:
Prim’s Algorithm (efficient for dense graphs)
Or Kruskal’s Algorithm with Union-Find (efficient for sparse graphs)
Since A and C can be up to 100,000, we’ll go with Prim’s Algorithm using a Min-Heap for better performance */
