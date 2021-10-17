import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        int len = times.length;
        long l_n = (long)n;
        long answer = (long)times[len-1] * l_n;
        long start = 1;
        long end = answer;

        while(start < end){
            long m = (start+end)/2;
            long temp = 0;
            for(int i = 0; i < len; i++){
                temp += m/times[i];
            }
            
            if(temp < n){
                if(start == m){
                    break;
                }
                start = m;
            }else{ // �ش� �ð� ���� ���� ������ ���
                answer = Math.min(answer,m); 
                end = m;
            }
            
        }
        
        return answer;
    }
}