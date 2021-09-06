import java.util.ArrayList;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] answers) {
       
        int[] option1 = {1, 2, 3, 4, 5};
        int[] option2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] option3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int len1 = option1.length;
        int len2 = option2.length;
        int len3 = option3.length;
        
        int[] count = {0, 0, 0};
        
        for(int i=0; i < answers.length; i++) {
            if(answers[i] == option1[i%len1])
                count[0] += 1;
            if(answers[i] == option2[i%len2])
                count[1] += 1;
            if(answers[i] == option3[i%len3])
                count[2] += 1;
        }
        
        int max = IntStream.of(count).max().getAsInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i < count.length; i++) {
            if(max == count[i]){
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i =0; i < answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}