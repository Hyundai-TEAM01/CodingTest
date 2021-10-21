class Solution {
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = createMap(rows, columns);
        
        for(int i=0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            answer[i] = rotate(map, x1, y1, x2, y2);
        }
        
        return answer;
    }
    
    public static int[][] createMap(int rows, int columns) {
        int[][] map = new int[rows+1][columns+1];
        int cnt = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = cnt++;
            }
        }
        return map;
    }
    
    public static int rotate(int[][] map, int x1, int y1, int x2, int y2) {
        int temp = map[x1][y1];
        int min = temp;
        
        // 왼쪽
        for(int i=x1; i < x2; i++) {
            map[i][y1] = map[i+1][y1];
            min = Math.min(min, map[i][y1]);
        }
        // 아래
        for(int i=y1; i < y2; i++) {
            map[x2][i] = map[x2][i+1];
            min = Math.min(min, map[x2][i]);
        }
        // 오른쪽
        for(int i=x2; i > x1; i--) {
            map[i][y2] = map[i-1][y2];
            min = Math.min(min, map[i][y2]);
        }
        // 위쪽
        for(int i=y2; i > y1; i--) {
            map[x1][i] = map[x1][i-1];
            min = Math.min(min, map[x1][i]);
        }
        map[x1][y1+1] = temp;
        
        return min;
    }
}