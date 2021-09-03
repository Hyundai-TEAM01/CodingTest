import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        int answer = 0;
        Arrays.sort(citations);
        
        if(citations[citations.length-1] == 0){
            return 0;
        }
        if(citations[0] > citations.length){
            return citations.length;
        }
        int no = 1;
        int index = 0;
        
        while(no <= citations.length){
            index = citations.length - no;
            
            if(citations[index] < no){
                return no-1;
            }
            no++;
        }
        return answer;
    }
}
