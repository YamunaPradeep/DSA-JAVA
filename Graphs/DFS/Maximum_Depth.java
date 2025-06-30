public class Solution {
    public int[] solve(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {
        // Step 1: Build the tree (adjacency list)
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < A - 1; i++) {
            tree.get(B[i]).add(C[i]);
            tree.get(C[i]).add(B[i]);
        }

        // Step 2: BFS from root to get level map and max depth
        Map<Integer, List<Integer>> levelMap = new HashMap<>();// Initialize the level map to store values at each depth level
        boolean[] visited = new boolean[A + 1]; // Visited array to make sure each node is processed only once
        Queue<int[]> queue = new LinkedList<>();// // BFS queue to process nodes level by level
        queue.add(new int[]{1, 0});  // node, level , Start BFS from the root node (node 1) at level 0
        visited[1] = true;

        int maxDepth = 0; // Initialize the maxDepth variable

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int level = curr[1];
            maxDepth = Math.max(maxDepth, level);

            // add node value (D[node - 1]) to corresponding level
            levelMap.putIfAbsent(level, new ArrayList<>());
            levelMap.get(level).add(D[node - 1]);

            for (int neighbor : tree.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, level + 1});
                }
            }
        }

        // Step 3: Sort each level's values
        for (List<Integer> list : levelMap.values()) {
            Collections.sort(list);
        }

        // Step 4: Answer the queries
        int Q = E.length;
        int[] result = new int[Q];

        for (int i = 0; i < Q; i++) {
            int level = E[i] % (maxDepth + 1);
            int x = F[i];

            if (!levelMap.containsKey(level)) {
                result[i] = -1;
                continue;
            }

            List<Integer> list = levelMap.get(level);

            // Binary search to find smallest value >= x
            int ans = -1;
            int low = 0, high = list.size() - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (list.get(mid) >= x) {
                    ans = list.get(mid);
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            result[i] = ans;
        }

        return result;
    }
}
