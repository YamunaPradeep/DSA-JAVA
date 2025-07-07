public class Solution {
    public int solve(int A, int[] B, int[] C) {
        // Step 1: Build the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) graph.add(new ArrayList<>());

        int[] inDegree = new int[A + 1];

        for (int i = 0; i < B.length; i++) {
            int u = B[i];
            int v = C[i];
            graph.get(u).add(v);
            inDegree[v]++;
        }

        // Step 2: Topo sort using BFS
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= A; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return count == A ? 1 : 0;
    }
}
