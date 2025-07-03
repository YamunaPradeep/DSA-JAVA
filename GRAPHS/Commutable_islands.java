/*inal Confirmed Understanding:
✅ Input: Connected weighted undirected graph.
✅ Output: Minimum total cost to connect all nodes (using MST).
✅ Algorithm: Prim’s  */

public class Solution {
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

        for (int[] bridge : B) {
            int u = bridge[0] - 1;  // convert to 0-based index
            int v = bridge[1] - 1;
            int cost = bridge[2];
            adj.get(u).add(new Pair(v, cost));
            adj.get(v).add(new Pair(u, cost)); // undirected
        }

        // Step 2: Prim's Algorithm
        boolean[] visited = new boolean[A];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Pair(0, 0));  // start from node 0
        int totalCost = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int cost = current.cost;

            if (visited[node]) continue;

            visited[node] = true;
            totalCost += cost;

            for (Pair neighbor : adj.get(node)) {
                if (!visited[neighbor.node]) {
                    pq.add(new Pair(neighbor.node, neighbor.cost));
                }
            }
        }

        return totalCost;
    }
}


