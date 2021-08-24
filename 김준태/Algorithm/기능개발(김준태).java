import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int day = 1;
        int speedIndex = 0;
        int count = 0;
        
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            qu.offer(progresses[i]);
        }
        
        while(qu.size() >= 0){
            if(qu.size() == 0){
                list.add(count);
                break;
            }
            
            int progress = qu.peek() + (speeds[speedIndex] * day);
            
            if (progress >= 100){
                count++;
                speedIndex++;
                qu.poll();
                continue;
            }
            if(count > 0){
                list.add(count);
                count = 0;
            }
            day++;
        }
        int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
