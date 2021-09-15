class Solution {
    public static int n;
    public static int target;
    public static int answer = Integer.MAX_VALUE;
    
    public int solution(int N, int number) {
        // 못 품
        // https://velog.io/@jwkim/DFS-n-expression
        n = N;
        target = number;
        dfs(0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public void dfs(int count, int prev) {
        if(count > 8) {
            answer = -1;
            return;
        }
        if(prev == target) {
            System.out.print(count + " ");
            answer = Math.min(answer, count);
            return;
        }
        int tempN = n;
        for(int i=0; i < 8 - count; i++) {
            int newCount = count + i + 1;
            dfs(newCount, prev + tempN);
            dfs(newCount, prev - tempN);
            dfs(newCount, prev / tempN);
            dfs(newCount, prev * tempN);
            
            tempN = tempN * 10 + n;
        }
        
    }
    
}