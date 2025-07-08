/*Pathfinding on a 2D Grid with Blocked Cells
The pattern is:
Grid → Graph (each cell is a node)
Movement → usually in 4 or 8 directions
Obstacles → cells you cannot visit
Goal → Is there a path from (0, 0) to (x, y)
This is a classic BFS Grid traversal problem.

Similar problems:
Maze solver (walls are blocked)
Minimum Steps in Matrix with Obstacles
Knight shortest path on chessboard
Shortest bridge (Leetcode)
Word Ladder (if you map words to neighbors)

✅ Step-by-Step Strategy to Remember This
1. Chunk it into Core Concepts
Instead of trying to remember everything, remember these 5 core things when you see a grid question:
📌 “5C Formula” for Grid + Graph Problems:
C1: Coordinates – Is it 0-based? (usually yes) → then size is maxIndex + 1
C2: Cell Status – Blocked or not → boolean[][] blocked
C3: Visited Tracking – To prevent cycles → boolean[][] visited
C4: Connection Direction – 4 or 8 directions? (prepare dx and dy)
C5: Conversion – From input format (circles, chars, strings) → into grid model
🧠 If you memorize this 5C checklist, you can apply it to every grid question! */

public class Solution {
    public String solve(int A, int B, int C, int D, int[] E, int[] F) {
        int rows = A + 1;
        int cols = B + 1;
        boolean[][] blocked = new boolean[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        // Mark all cells that are inside or on any circle as blocked
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < C; k++) {
                    int cx = E[k];
                    int cy = F[k];
                    double distance = Math.sqrt((i - cx) * (i - cx) + (j - cy) * (j - cy));
                    if (distance <= D) {
                        blocked[i][j] = true;
                        break;
                    }
                }
            }
        }

        // If start or end is blocked, return NO
        if (blocked[0][0] || blocked[A][B]) return "NO";

        // BFS
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            if (x == A && y == B) return "YES";

            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols &&
                        !blocked[newX][newY] && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return "NO";
    }
}
