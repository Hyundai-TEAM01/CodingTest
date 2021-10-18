class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] arr = new boolean[n][n];
        
        for(int i = 0; i < results.length; i++){
            arr[results[i][0]-1][results[i][1]-1] = true;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(arr[j][i]&&arr[i][k]){
                        arr[j][k] = true;
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            int result = 0;
            for(int j = 0; j < n; j++){
                if(arr[i][j] || arr[j][i]){
                    result++;
                }
            }
            
            if(result == n-1){
                answer++;
            }
        }
        
        return answer;
    }
}