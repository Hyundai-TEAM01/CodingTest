import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++ ){
            q.add(scoville[i]);
        }
        
        while(q.size() > 1){
            int temp = q.peek();
            if(temp >= K){
                break;
            }else{
                q.add(q.poll() + (q.poll()*2));
                answer++;
            }
        }
        
        if(q.peek() >= K){
            return answer;
        }else{
            return -1;
        }
    }
}