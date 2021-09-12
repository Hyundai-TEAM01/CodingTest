import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Deque<Character> li = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < number.length(); i++){
            char c = number.charAt(i);
            if(k == 0){ // 종료 조건
                while(li.size() < number.length() - k && i < number.length()){ // 남은 문자열 추가
                    li.add(number.charAt(i++));
                }
                break;
            }else{
                 while(!li.isEmpty() && li.peekLast() < c && k != 0){ // 자기보다 작은 값을 제거
                    li.pollLast();
                    k--; // 버린 문자열의 수를 증가
                 }
                if(li.size() < number.length() - k)
                    li.add(c);
            }
                
        }

        String[] str = {"0","1","2","3","4","5","6","7","8","9"};
        while(!li.isEmpty()){
            sb.append(str[li.poll()-'0']);
        }
        
        return sb.toString();
        }
    }