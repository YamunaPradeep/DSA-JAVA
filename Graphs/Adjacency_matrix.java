//Undirected Graph
public class UndirectedGraphMatrix {
    public int[][] buildAdjMatrix(int A, int[][] B) {
        int[][] matrix = new int[A][A];

        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];

            matrix[u][v] = 1;
            matrix[v][u] = 1; // reverse edge for undirected
        }

        return matrix;
    }
}

//Directed Graph
public class DirectedGraphMatrix {
    public int[][] buildAdjMatrix(int A, int[][] B) {
        int[][] matrix = new int[A][A];

        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];

            matrix[u][v] = 1; // only one direction
        }

        return matrix;
    }
}

/*What is an Adjacency Matrix?
An adjacency matrix is a 2D array where:
matrix[i][j] = 1 means there's an edge from i to j
For undirected graphs, matrix[j][i] is also 1
For directed graphs, matrix[j][i] stays 0 unless explicitly added 
Undirected graphs are symmetrix matrix */

