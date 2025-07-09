public class Solution {
    public String solve(int A, int B, int C, int D, int[] E, int[] F) {
        int row = A+1;
        int col = B+1;
        boolean[][] blocked = new boolean[row][col];
        boolean[][] visited = new boolean[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col ; j++){
                for(int k=0; k<C; k++){
                    int cx = E[k];
                    int cy = F[k];
                    double distance = Math.sqrt((i-cx)*(i-cx)+(j-cy)*(j-cy));
                    if(distance <= D){
                        blocked[i][j] = true;
                        break;
                    }
                }
            }
        }

        if(blocked[0][0] || blocked[A][B]) return "NO";

        int[] dx ={-1,0,1,-1,1,-1,0,-1};
        int[] dy = {1,1,1,0,0,-1,-1,-1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

        

             if(x == A && y== B) return "YES";

            for(int i=0; i<8; i++){
               int newX = x + dx[i];
               int newY = y + dy[i];

                 if(newX >=0 && newX < row && newY >=0 && newY < col && !visited[newX][newY] &&
                 !blocked[newX][newY]){
                
                   visited[newX][newY] = true;
                   queue.offer(new int[]{newX,newY});
                 }

            }

           
         
        }
        return "NO";

        
    }
}
