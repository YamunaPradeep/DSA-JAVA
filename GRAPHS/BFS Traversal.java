public class Solution {
    public ArrayList<Integer> bfsTraversal(int A, ArrayList<ArrayList<Integer>> B) {
        // A = number of nodes (0 to A-1)
        // B = list of edges [u, v]

        // Step 1: Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : B) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u); // comment this if graph is directed
        }

        // Step 2: Prepare BFS traversal
        boolean[] visited = new boolean[A];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        // For disconnected graph, do BFS from all components
        for (int i = 0; i < A; i++) {
            if (!visited[i]) {
                q.offer(i);
                visited[i] = true;

                while (!q.isEmpty()) {
                    int curr = q.poll();
                    result.add(curr);

                    for (int neighbor : adj.get(curr)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            q.offer(neighbor);
                        }
                    }
                }
            }
        }

        return result;
    }
}
