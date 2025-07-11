public class Solution {
    public int[] bfsTraversal(int A, int[][] B) {
        // A = number of nodes (0 to A-1)
        // B = edge list

        // Step 1: Create adjacency list using arrays
        List<Integer>[] adj = new ArrayList[A];
        for (int i = 0; i < A; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u); // remove this line for directed graph
        }

        // Step 2: BFS Traversal
        boolean[] visited = new boolean[A];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            if (!visited[i]) {
                q.offer(i);
                visited[i] = true;

                while (!q.isEmpty()) {
                    int curr = q.poll();
                    result.add(curr);

                    for (int neighbor : adj[curr]) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            q.offer(neighbor);
                        }
                    }
                }
            }
        }

        // Convert result list to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
