import java.util.*;

class Solution {
    static int[] mx = {-1,0,1,0};
    static int[] my = {0,1,0,-1};
    public int[] solution(String[] grid) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        int X = grid.length;
        int Y = grid[0].length();
        
        boolean[][][] visited = new boolean[X][Y][4];
        
        for(int i = 0; i < X; i++){
            for(int j = 0; j < Y; j++){
                for(int k = 0; k < 4; k++){
                    if(!visited[i][j][k]){ // k 0 위 1 오른쪽 2 아래 3 왼쪽
                        int cnt = 0;
                        int x = i;
                        int y = j;
                        int d = k;
                        while(true){
                            if(visited[x][y][d]){
                                break;
                            }
                            visited[x][y][d] = true;
                            if(grid[x].charAt(y) == 'L'){ // 좌회전
                                // 0 -> 3
                                // 1 -> 0
                                // 2 -> 1
                                // 3 -> 2
                                d = d == 0 ? 3 : d-1; 
                            }else if(grid[x].charAt(y) == 'R'){
                                // 0 -> 1
                                // 1 -> 2
                                // 2 -> 3
                                // 3 -> 0
                                d = d == 3 ? 0 : d+1;
                            }
                            // 0,0 -> 1,0
                            x = (x + mx[d] + X)%X;
                            y = (y + my[d] + Y)%Y;
             
                            cnt++;
                        }
                        arr.add(cnt);
                    }
                }
            }
        }

        
        int[] answer = new int[arr.size()];
        
        arr.sort(null);
        
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }        
        return answer;
    }
}