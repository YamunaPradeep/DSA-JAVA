public class Solution {
    public int[] solve(int A, int[][] B, int C) {
        // Step 1: Create adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : B) {
            int u = edge[0], v = edge[1], wt = edge[2];
            graph.get(u).add(new int[]{v, wt});
            graph.get(v).add(new int[]{u, wt}); // Undirected graph
        }

        // Step 2: Initialize distance array
        int[] dist = new int[A];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[C] = 0;

        // Step 3: Min Heap using PriorityQueue: [node, distance]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{C, 0});

        // Step 4: Dijkstra's logic
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if (d > dist[node]) continue; // Skip if outdated

            for (int[] nbr : graph.get(node)) {
                int adj = nbr[0];
                int weight = nbr[1];

                if (dist[node] + weight < dist[adj]) {
                    dist[adj] = dist[node] + weight;
                    pq.add(new int[]{adj, dist[adj]});
                }
            }
        }

        // Step 5: Convert unreachable nodes (Integer.MAX_VALUE) to -1
        for (int i = 0; i < A; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
