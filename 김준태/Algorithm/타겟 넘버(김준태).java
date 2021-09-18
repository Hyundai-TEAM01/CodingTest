class Solution {
    static int count = 0;
    
    public static void dfs(int[] numbers, int depth, int target, int value){
        
        // 종료 조건
        if (depth  == numbers.length){
            if (value == target){
                // System.out.println(depth + " 일 때 " + value);
                count++;
                return;
            }
        }
        
        if ( depth < numbers.length ){
            // System.out.println(depth + 1 + " " + numbers[depth] + " value : " + value);
            dfs(numbers, depth + 1, target, value + numbers[depth]);
            dfs(numbers, depth + 1, target, value - numbers[depth]);
        }
    }
    
    
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(numbers, 0, target, 0);
        
        return answer = count;
    }
}
