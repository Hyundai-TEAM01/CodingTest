class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,0,numbers.length,target,0);
        return answer;
    }
    
    static void dfs(int[] numbers, int nowDepth, int depth, int target, int sum){
        if(nowDepth == depth){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        dfs(numbers,nowDepth+1,depth,target,sum + numbers[nowDepth]);
        dfs(numbers,nowDepth+1,depth,target,sum - numbers[nowDepth]);
        
    }
}