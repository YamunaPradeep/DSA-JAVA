public class Solution {
    public int solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        // 8 directions: top-left, top, top-right, right, bottom-right, bottom, bottom-left, left
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(A, visited, i, j, rows, cols, dx, dy);
                }
            }
        }

        return count;
    }

    private void dfs(int[][] A, boolean[][] visited, int x, int y, int rows, int cols, int[] dx, int[] dy) {
        visited[x][y] = true;

        for (int k = 0; k < 8; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];

            if (newX >= 0 && newY >= 0 && newX < rows && newY < cols &&
                A[newX][newY] == 1 && !visited[newX][newY]) {
                dfs(A, visited, newX, newY, rows, cols, dx, dy);
            }
        }
    }
}
