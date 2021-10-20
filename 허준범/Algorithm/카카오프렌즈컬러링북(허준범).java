import java.util.*;

class Solution {
    
    class Node {
        public int x;
        public int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        int max_val = 0;
        int area = 0;
        
        visited = new boolean[m][n];
        
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(picture[i][j] != 0 && visited[i][j] == false) {
                    max_val = Math.max(max_val, bfs(picture, m, n, picture[i][j], i, j));
                    area++;
                }
            }
        }
        
        answer[0] = area;
        answer[1] = max_val;
        
        return answer;
    }
    
    public int bfs(int[][] picture, int m, int n, int target, int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(i, j));
        visited[i][j] = true;
        int count = 1;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            
            for(int k=0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                // 범위, 타겟넘버, 방문 확인
                if(nx < 0 || ny < 0 || nx >= m || ny >= n || picture[nx][ny] != target || visited[nx][ny]) continue;
                count++;
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }
        
        return count;
    }
    
}