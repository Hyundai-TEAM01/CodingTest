class Solution {
    public int solution(int[][] triangle) {
        // 못 품 정답 코드 이해함
        // 높이는 1부터 시작
        for(int i=1; i < triangle.length; i++) {
            triangle[i][0] = triangle[i][0] + triangle[i-1][0]; // 왼쪽 모서리
            triangle[i][i] = triangle[i][i] + triangle[i-1][i-1]; // 오른쪽 모서리
            for(int j=1; j < i; j++) // 가운데 1부터 시작 
                triangle[i][j] = triangle[i][j] + Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }
        
        int answer = 0;
        int lastSize = triangle.length-1; // 마지막 행 열 인덱스
        for(int i=0; i < lastSize; i++)
            answer = Math.max(answer, triangle[lastSize][i]);
        
        return answer;
    }
}