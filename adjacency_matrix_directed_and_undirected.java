//1. Directed Graph – Adjacency Matrix (Scaler Style)

public class Solution {
    public int[][] buildDirectedAdjMatrix(int A, int[][] B) {
        int[][] matrix = new int[A + 1][A + 1];

        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            matrix[u][v] = 1; // Directed edge u -> v
        }

        return matrix;
    }
}
//2. Undirected Graph – Adjacency Matrix (Scaler Style)

public class Solution {
    public int[][] buildUndirectedAdjMatrix(int A, int[][] B) {
        int[][] matrix = new int[A + 1][A + 1];

        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            matrix[u][v] = 1;
            matrix[v][u] = 1; // Because undirected: u <-> v
        }

        return matrix;
    }
}


/*Space Complexity: O(N^2) – Useful when N is small or edge presence lookup is frequent.
Difference Between Directed & Undirected:
Directed ➝ matrix[u][v] = 1
Undirected ➝ matrix[u][v] = matrix[v][u] = 1 */
