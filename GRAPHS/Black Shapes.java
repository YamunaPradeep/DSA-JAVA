public class Solution {
    public int black(String[] A) {
        int n = A.length;
        int m = A[0].length();
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        // 4 directions: up, right, down, left
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i].charAt(j) == 'X' && !visited[i][j]) {
                    dfs(A, visited, i, j, dx, dy, n, m);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(String[] A, boolean[][] visited, int x, int y, int[] dx, int[] dy, int n, int m) {
        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];

            if (newX >= 0 && newX < n && newY >= 0 && newY < m &&
                A[newX].charAt(newY) == 'X' && !visited[newX][newY]) {
                dfs(A, visited, newX, newY, dx, dy, n, m);
            }
        }
    }
}

