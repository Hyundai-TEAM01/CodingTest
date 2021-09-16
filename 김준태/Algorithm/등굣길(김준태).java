class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int dp[][] = new int[n][m];
        
        dp[0][0] = 1;
        
        for(int i = 0; i < puddles.length; i++){
            int row = puddles[i][0] - 1;
            int col = puddles[i][1] - 1;
            dp[col][row] = -1;
        }
        
        for(int i = 1; i < n; i++){
            if(dp[i][0] != -1){
                dp[i][0] = dp[i - 1][0];
            }
        }
        for(int j = 1; j < m; j++){
            if(dp[0][j] != -1){
                dp[0][j] = dp[0][j-1];
            }
        }
        
        
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(dp[i][j] == -1){
                    dp[i][j] = 0;
                } else{
                    if(dp[i-1][j] == -1 && dp[i][j-1] == -1){
                        dp[i][j] = 0;
                    } else{
                        if(dp[i-1][j] == -1){
                            dp[i][j] = dp[i][j-1];
                        } else if(dp[i][j-1] == -1){
                            dp[i][j] = dp[i-1][j];
                        } else{
                            dp[i][j] = dp[i-1][j] + dp[i][j-1];    
                        }
                    }
                }
                dp[i][j] = dp[i][j] % 1000000007;
            }
        }
        
        return dp[n-1][m-1];
    }
}
