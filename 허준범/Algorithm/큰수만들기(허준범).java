import java.util.*;

class Solution {
    public String solution(String number, int k) {
        // https://www.acmicpc.net/problem/17298 비슷한 유형,이것도 풀어보자
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>(); // 만들려는 숫자 
        
        // (핵심)만들려는 숫자는 첫 번째 숫자가 크면 된다.
        for(int i=0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';
            while(!stack.isEmpty() && num > stack.peek()) { // stack 비어있지 않고, 새로운 num > Top 일 때 
                if(k > 0) { // 제거할 수의 개수
                    stack.pop();
                    k--;
                }
                else // 모두 제거한 경우
                    break;
            }
            stack.push(num);
        }
        
        while(k > 0) { // 모두 제거못한 경우
            stack.pop();
            k--;
        }
        
        for(int val : stack)
            sb.append(val);
        
        answer = sb.toString();
        
        return answer;
    }
}