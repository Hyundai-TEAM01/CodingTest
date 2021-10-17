import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // https://yubh1017.tistory.com/30
        long answer = Long.MAX_VALUE;
        
        Arrays.sort(times);
        long start = 0;
        long end = Long.MAX_VALUE;
        
        while(start <= end){
            long mid = (start + end) / 2;
            long sum = 0;
            // 주어진 시간동안 몇명 검사 할 수 있는지 누적합
            for(int i=0; i<times.length; i++){
                sum += mid / times[i];
                if(sum >= n)
                    break;
            }
            // 비교 대상(사람 수)
            // 검사 다 못할 때(시간 부족)
            if(n > sum){
                start = mid + 1;
            }
            // 검사 다 했을 때 (시간이 남음)
            // 최소 시간 찾아야함
            else{
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        System.out.println(answer);
        return answer;
    }
    
}