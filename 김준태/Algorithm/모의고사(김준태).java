import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] scores = new int[3];
        
        int[] pattern1 = {1, 2, 3, 4, 5}; // 5
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        
        ArrayList<Integer> listAnswer = new ArrayList<>();
        
        
        for (int i = 0; i < answers.length; i++){
            int ans = answers[i];
            if (ans == pattern1[i % 5]){
                scores[0]++;
            }
            if (ans == pattern2[i % 8]){
                scores[1]++;
            }
            if (ans == pattern3[i % 10]){
                scores[2]++;
            }
        }
        
        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
        for(int i = 0; i < scores.length; i++){
            if(max == scores[i]){
                listAnswer.add(i+1);
            }
        }
        
        answer = listAnswer.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}
