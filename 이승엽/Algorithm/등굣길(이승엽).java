class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int [][] map = new int[n+1][m+1];
		int [][] cache = new int[n+1][m+1];
        for(int i = 0; i < puddles.length;i++) {
			map[puddles[i][1]][puddles[i][0]] = 1;
		}
        if(map[1][2] != 1){
            cache[1][2] = 1;    
        }
        if(map[2][1] != 1){
            cache[2][1] = 1;    
        }
		
		
		for(int i = 1; i < m+1; i++) {
			for(int j = 1; j < n+1; j++) {
				if(map[j][i] == 1) {
					continue;
				}
				if(i-1 > 0 && map[j][i-1] != 1) {
					cache[j][i] += (cache[j][i-1])%1000000007;
				}
				if(j-1 > 0 && map[j-1][i] != 1) {
					cache[j][i] += (cache[j-1][i])%1000000007;
				}
			}
		}
        return cache[n][m]%1000000007;
    }
}