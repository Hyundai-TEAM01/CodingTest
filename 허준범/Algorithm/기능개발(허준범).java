import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] answer = new int[n];
        int[] distribution = new int[n]; // 배포 날짜
        
        for(int i=0; i < n; i++) {
            int day = 0;
            int process = progresses[i];
            while(process < 100) {
                process += speeds[i];
                day++;
            }
            distribution[i] = day;
        }
        
        
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int idx = 0;
        
        for(int i=0; i < n; i++) {
            if(stack.isEmpty()) { // 시작
                stack.push(distribution[i]);
                count++;
            }
            else if(stack.peek() >= distribution[i]) { // 스택에 마지막 기능이랑 다음 기능이랑 비교
                count++; // 같거나 크면 한 번에 배포 숫자 + 1 
            }
            else if(stack.peek() < distribution[i]) { // 다음 기능이 더 오래 걸리면
                stack.pop();
                stack.push(distribution[i]);
                answer[idx++] = count; // 한 번에 배포 숫자 적어줌.
                count = 1;
            }
        }
        
        if(!stack.isEmpty()) // 스택에 남아있는 거 처리
            answer[idx] = count;
        
        answer = Arrays.copyOfRange(answer, 0, idx+1); // 저장된 값만큼만 출력
        
        return answer;
    }
}