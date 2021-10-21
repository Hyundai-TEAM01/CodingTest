// 참고 : https://fbtmdwhd33.tistory.com/225
class Solution {
    
    static int numberOfArea;
    static int maxSizeOfOneArea;
    
    static int temp_cnt = 0;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void dfs(int x, int y, int[][] picture, boolean[][] visited){
        if(visited[x][y]) return;
        
        visited[x][y] = true;
        temp_cnt++;
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length) continue;
            
            if(picture[x][y] == picture[nx][ny] && !visited[nx][ny]){
                dfs(nx, ny, picture, visited);
            }
        }
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] != 0 && !visited[i][j]){
                    numberOfArea++;
                    dfs(i, j, picture, visited);
                }
                if(temp_cnt > maxSizeOfOneArea) maxSizeOfOneArea = temp_cnt;
                
                temp_cnt = 0;
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
}
