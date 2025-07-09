public class Solution {
    public void solve(ArrayList<ArrayList<Character>> a) {
        int n = a.size();
        int m = a.get(0).size();

        // Step 1: Run DFS on all border 'O's
        for (int i = 0; i < n; i++) {
            if (a.get(i).get(0) == 'O') dfs(a, i, 0, n, m);
            if (a.get(i).get(m - 1) == 'O') dfs(a, i, m - 1, n, m);
        }

        for (int j = 0; j < m; j++) {
            if (a.get(0).get(j) == 'O') dfs(a, 0, j, n, m);
            if (a.get(n - 1).get(j) == 'O') dfs(a, n - 1, j, n, m);
        }

        // Step 2: Convert all remaining 'O' to 'X', and '#' back to 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a.get(i).get(j) == 'O') {
                    a.get(i).set(j, 'X');
                } else if (a.get(i).get(j) == '#') {
                    a.get(i).set(j, 'O');
                }
            }
        }
    }

    private void dfs(ArrayList<ArrayList<Character>> a, int x, int y, int n, int m) {
        // Boundary + base condition
        if (x < 0 || y < 0 || x >= n || y >= m || a.get(x).get(y) != 'O') return;

        // Temporarily mark safe 'O' as '#'
        a.get(x).set(y, '#');

        // Explore 4 directions
        dfs(a, x - 1, y, n, m);
        dfs(a, x + 1, y, n, m);
        dfs(a, x, y - 1, n, m);
        dfs(a, x, y + 1, n, m);
    }
}
