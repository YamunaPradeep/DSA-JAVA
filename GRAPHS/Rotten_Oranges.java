public class Solution {
    class Cell {
        int row, col, time;
        Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        Queue<Cell> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all rotten oranges to queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 2) {
                    q.add(new Cell(i, j, 0));
                } else if (A[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Directions: up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int time = 0;

        // Step 2: BFS
        while (!q.isEmpty()) {
            Cell curr = q.poll();
            time = Math.max(time, curr.time);

            for (int d = 0; d < 4; d++) {
                int nr = curr.row + dr[d];
                int nc = curr.col + dc[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && A[nr][nc] == 1) {
                    A[nr][nc] = 2; // mark as rotten
                    fresh--;
                    q.add(new Cell(nr, nc, curr.time + 1));
                }
            }
        }

        return fresh == 0 ? time : -1;
    }
}


/*Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
Each cell can have three values:
The value 0 representing an empty cell.
The value 1 representing a fresh orange.
The value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them. */

/*Algorithm Steps:
🔹 Step 1: Initialization
Create a queue q to perform BFS.
Initialize a counter fresh = 0 to count the number of fresh oranges.
Traverse the entire matrix:
If A[i][j] == 2, push it to the queue with time = 0 → it’s a rotten orange (starting point).
If A[i][j] == 1, increment fresh → it's a fresh orange.
🔹 Step 2: Multi-source BFS
Define 4 direction arrays: dr[] = {-1, 1, 0, 0} and dc[] = {0, 0, -1, 1} for up, down, left, and right.
Initialize time = 0.
While the queue is not empty:
Dequeue a Cell(row, col, time) from the queue.
For each of the 4 directions:
Compute the next cell (nr, nc) = (row + dr[i], col + dc[i]).
If the cell is in bounds and contains a fresh orange:
Turn it rotten (A[nr][nc] = 2)
Decrement fresh--
Enqueue the new rotten orange with time + 1
🔹 Step 3: Result
If fresh == 0, return the time taken (all oranges are rotten).
Else, return -1 (some oranges were unreachable).
🧠 Key Points:
This is a multi-source BFS because all initially rotten oranges spread rot at the same time.
We track the max time seen in the BFS to determine how long it took. 
⏱️ Time Complexity:
O(N * M) – Each cell is visited at most once.
📦 Space Complexity:
O(N * M) – For queue and auxiliary space.*/
