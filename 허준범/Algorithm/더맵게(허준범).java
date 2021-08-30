import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> priorQue = new PriorityQueue<>(); // 우선순위 큐
        
        for(int food : scoville) // 모든 음식 넣기, 자동으로 스코빌 낮은 순서로 정렬된다.
            priorQue.add(food); 
        
        int cntMix = 0; // 총 섞은 횟수
        
        while(priorQue.size() > 1) { // 2개씩 뽑기 때문에 음식이 2개 이상일때만 수행
            if(priorQue.peek() >= K) // 젤 낮은 스코빌이 K이상이면 종료
                break;
            int a = priorQue.remove();
            int b = priorQue.remove();
            int c = a + (b*2);
            priorQue.add(c);
            cntMix++;    
        }
        
        if(priorQue.peek() < K) // 가장 낮은 스코빌 지수 확인
            answer = -1;
        else // 제한 사항에서 모든 음식을 K이상으로 만들 수 없는 경우 -1 return
            answer = cntMix;
        
        return answer;
    }
}