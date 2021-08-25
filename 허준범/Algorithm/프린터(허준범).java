import java.util.*;

class Node {
    int prior;
    int idx;
    
    Node(int prior, int idx) {
        this.prior = prior;
        this.idx = idx;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        
        for(int i=0; i < priorities.length; i++) {
            queue.add(new Node(priorities[i], i));    
        }
        
        int printNum = 0;
        while(true) {
            Node priority = queue.remove(); // 설명 1: 대기목록 맨 앞 문서 꺼냄
            boolean isExist = false;
            
            for(Node item : queue) {    // 나머지 문서와 비교
                if(priority.prior < item.prior) {
                    isExist = true;
                    break;
                }
            }
            
            if(isExist) { // 설명 2 : 중요도 높은 문서가 존재
                queue.add(priority);
            } else { // 설명 3 : 없으면 인쇄
                printNum++;
                if(priority.idx == location) { // 내가 요청한 문서면
                    answer = printNum;
                    break;
                }
            }
            
        }
        
        return answer;
    }
}