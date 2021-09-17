class Solution {
    public static int cnt; // 결과 출력용 
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(0, numbers.length, target, numbers, 0);
        answer = cnt;
        return answer;
    }
    
    // depth: 배열인덱스, m: 종료조건, target: 타겟넘버, numbers: 숫자배열, value: 진행중인 넘버
    public void dfs(int depth, int m, int target, int[] numbers, int value) {
        if(depth == m) {
            if(value == target)
                cnt++;
            return;
        }
        dfs(depth+1, m, target, numbers, value + numbers[depth]);
        dfs(depth+1, m, target, numbers, value - numbers[depth]);
    }
}