import java.util.*;
class Solution {
    static int[] move_x = {0,0,1,-1};
    static int[] move_y = {1,-1,0,0};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 0){
                    visited[i][j] = true;
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    numberOfArea++;
                    Deque<Pair> q = new ArrayDeque();
                    q.add(new Pair(i,j,picture[i][j]));
                    visited[i][j] = true;
                    int temp = 0;
                    while(!q.isEmpty()){
                        Pair now = q.poll();
                        temp++;
                        for(int k = 0; k < 4; k++){
                            int next_x = now.x+move_x[k];
                            int next_y = now.y+move_y[k];
                            if(0 <= next_x && next_x < m && 0 <= next_y && next_y < n
                              && picture[next_x][next_y] == now.val 
                               && !visited[next_x][next_y]){
                                q.add(new Pair(next_x,next_y,now.val));
                                visited[next_x][next_y] = true;
                            }
                        }
                    }
                    maxSizeOfOneArea = Math.max(temp,maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    static class Pair{
        int x,y,val;
        public Pair(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}