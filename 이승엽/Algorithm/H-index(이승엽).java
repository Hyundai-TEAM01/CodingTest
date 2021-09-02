import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        if(citations[0] > citations.length){ // 제일 적은 인용 수가 citations의 길이보다 길 때
            return citations.length;
        }else{
            // h-index의 최대값은 citations의 길이보다 작다.
            // for(int i = citations.length-1 ; i >=  citations[0]+1; i--){ 
            for(int i = citations.length-1 ; i >=  1; i--){ 
                if( citations[citations.length-i] >= i){
                    return i;
                }
            }
        }
        

        
        return answer;
    }
}