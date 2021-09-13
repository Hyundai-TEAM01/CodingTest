import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int peolen = people.length; // 사람 수
        int left = 0; // 낮은 몸무게
        int right = people.length-1; // 높은 몸무게
        
        Arrays.sort(people); // 몸무게 오른차순 정렬
        
        // 투 포인터 문제
        while(left < right) {
            int sumVal = people[left] + people[right];
            if(sumVal <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            answer++;
            if(left == right) {
                answer++;
            }
        }
    
        return answer;
    }
}