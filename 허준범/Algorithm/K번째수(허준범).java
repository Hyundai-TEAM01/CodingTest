import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int idx = commands[i][2] - 1;
            
            int[] subArr = new int[end-start+1]; // subArr 생성
            
            for(int j=0; j < subArr.length; j++) {
                subArr[j] = array[j+start];
            }
            
            Arrays.sort(subArr);    // 정렬
            answer[i] = subArr[idx];
            
        }
        return answer;
    }
}