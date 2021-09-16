class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // 질문하기에서 힌트 2가지 얻음
        // 행렬을 1로 초기화해서 풀려면 틀림
        // https://programmers.co.kr/questions/15829 참고
        // 정확성 100% 일 때, 효율성 0%인 이유는
        // 모든 모듈에 대해서 % 1000000007 해주어야함.
        int answer = 0;
        int[][] graph = new int[n+1][m+1];
        boolean[][] watered = new boolean[n+1][m+1];
        
        for(int i=0; i < puddles.length; i++) {
            int col = puddles[i][0];
            int row = puddles[i][1];
            watered[row][col] = true;
        }
        
        // 행열1로 채우는 방식 X
        // for(int i=1; i < m+1; i++)
        //     graph[1][i] = 1;
        // for(int j=1; j < n+1; j++)
        //     graph[j][1] = 1;
        // 시작 지점만 1로 초기화 & 방문처리
        graph[1][1] = 1;
        watered[1][1] = true;
        
        for(int i=1; i < n+1; i++) {
            for(int j=1; j < m+1; j++) {
                if(watered[i][j] == false) {
                    // 경로 = 현재 위치 인덱스의 위쪽 + 왼쪽
                    graph[i][j] = (graph[i-1][j] + graph[i][j-1]) % 1000000007;
                }
            }
        }
        
        // 출력해봄
        // for(int i=0; i < n+1; i++) {
        //     for(int j=0; j < m+1; j++) {
        //         System.out.print(graph[i][j] + " ");
        //     }
        //     System.out.println();       
        // }
        
        answer = graph[n][m];
        return answer;
    }
}

/*
-- 웅덩이 있을 때
[ 0, 0, 0, 0, 0]
[ 0, 0, 1, 1, 1]
[ 0, 1, x, 1, 2]
[ 0, 1, 1, 2, 4]

-- 웅덩이 없을 때
[ 0, 0, 0, 0, 0]
[ 0, 1, 1, 1, 1]
[ 0, 1, 2, 3, 4]
[ 0, 1, 3, 6, 10]
*/