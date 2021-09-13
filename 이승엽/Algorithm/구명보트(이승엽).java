import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int l = 0;
        int r = people.length-1;
        
        while(l < r){
            if(people[l]+people[r] > limit){ // 제일 작은 값 + 큰 값이 limit보다 클 때
                r--;
                answer++;
            }else{ // 작거나 같을 때
                l++;
                r--;
                answer++;
            }
        }
        
        if(l == r){ // 마지막 남은 값이 있을 경우
            answer++;
        }
        
        
        return answer;
    }
}