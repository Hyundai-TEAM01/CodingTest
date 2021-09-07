class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown+yellow;
        int[] answer = new int[2];
        for(int i = 3; i <= sum/2; i++){
            int x = sum/i;
            int y = i;
            if((x-2)*(y-2) == yellow){
                answer[0] = x;
                answer[1] = y;
                return answer;
            }
        }
        return answer;
    }
}