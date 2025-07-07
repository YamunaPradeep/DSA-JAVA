public class Solution {
    public int[] solve(int A, int[][] B) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[A + 1];
        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            inDegree[v]++;
        }

        // Use min-heap to get lexicographically smallest order
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= A; i++) {
            if (inDegree[i] == 0) {
                pq.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int node = pq.poll();
            result.add(node);

            for (int nbr : graph.get(node)) {
                inDegree[nbr]--;
                if (inDegree[nbr] == 0) {
                    pq.offer(nbr);
                }
            }
        }

        if (result.size() != A) {
            return new int[0]; // cycle exists
        }

        // Convert List to array
        int[] topo = new int[A];
        for (int i = 0; i < A; i++) {
            topo[i] = result.get(i);
        }
        return topo;
    }
}
