import java.util.*;

// 참고 : https://iamheesoo.github.io/blog/algo-prog49191
// 숏코드 : https://in-intuition.tistory.com/25
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int INF = 7;
        int m = results.length;
        int[][] fw = new int[n+1][n+1];
        
        // 모든 경로 INF로 채우기 
        for(int[] arr : fw) {
            Arrays.fill(arr, INF); 
        }
        
        // 한방향 그래프의 승리 결과 채우기
        for(int[] result:results){
            int win = result[0];
            int lose = result[1];
            fw[win][lose] = 1;
        }
        
        // 최단 경로 저장
        // k : 거쳐가는 꼭짓점
        // i : 출발하는 꼭짓점
        // j : 도착하는 꼭짓점
        for(int k=1;k<=n;k++){
             for(int i=1;i<=n;i++){
                 for(int j=1;j<=n;j++){
                     if(fw[i][j]>fw[i][k]+fw[k][j]){
                         fw[i][j]=fw[i][k]+fw[k][j];
                     }
                 }
             }
         }
        // 선수 i는 나를 제외한 n-1명과 방문할 수 있어야 승패를 알 수 있다.
        boolean[] flag = new boolean[n+1];
        Arrays.fill(flag, true);
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i==j) continue;
                if(fw[i][j] == INF && fw[j][i] == INF){
                    flag[i] = false;
                    break;
                }
            }
        }
        
        for(int i = 1; i < flag.length; i++){
            if(flag[i]) answer++;
        }
        
        
        
        return answer;
    }
}
