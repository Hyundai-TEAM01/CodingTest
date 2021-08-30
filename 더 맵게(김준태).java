import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int k : scoville){
            heap.offer(k);
        }
        
        while(heap.size() > 1){
            if(heap.peek() < K){
                heap.offer(heap.poll() + (heap.poll() * 2));
                answer++;
            } else {
                break;
            }
        }
        
        if(heap.size() == 1 && heap.peek() < K){
            answer=-1;
        }
        
        return answer;
    }
}
