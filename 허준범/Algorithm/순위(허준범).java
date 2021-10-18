class Solution {
    
    public static int[][] graph;
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        graph = new int[n+1][n+1];
        for(int i=0; i < n+1; i++) {
            for(int j=0; j < n+1; j++) {
                if(i== j) {
                    // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
                    graph[i][j] = 0;
                } else { 
                    // 아니면 무한
                    graph[i][j] = INF;    
                }
            }
        }
        
        // 각 간선에 대한 정보를 입력받아, 그 값으로 초기화
        for(int i=0; i < results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            graph[a][b] = 1;
        }
        
        // 플로이드 워셜 알고리즘 수행
        for(int k=1; k < n+1; k++) {
            for(int a=1; a < n+1; a++) {
                for(int b=1; b < n+1; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
        
        int result = 0;
        // 각 선수를 번호에 따라 한 명씩 확인하며 도달 가능한지 체크
        for(int i=1; i < n+1; i++) {
            int count = 0;
            for(int j=1; j < n+1; j++) {
                if(graph[i][j] != INF || graph[j][i] != INF) {
                    // 만약 둘 중 하나라도 연결되어 있다면
                    count++;
                }
            }
            if(count == n) {
                // 특정 노드의 연결된 값이 선수 전체 수와 같다면 정확한 순위를 알 수 있다
                result ++;
            }
        }
        
        answer = result;
        
        return answer;
    }
} 