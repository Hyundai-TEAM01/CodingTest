class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int len = name.length();
        // 맨오른쪽으로 하나씩 이동할 때 (초기값)
        int min = len - 1; 
        
        // JAACBZ
        // i는 다음에 움직여야할 위치
        // 다음에 움직여야할 위치가 왼쪽으로 갈 때와 오른쪽으로 갈때 를 비교해서 방향을 정한다.
        
        for(int i = 0; i < len; i++){
            char word = name.charAt(i);
            answer += (word-'A' <= 'Z' - word + 1) ? word-'A' : 'Z' - word + 1;
            
            int nextIndex = i + 1;
            while(nextIndex < len && name.charAt(nextIndex) == 'A'){
                nextIndex++;
            }
            
            min = Math.min(min, (i * 2) + len - nextIndex);
            
        }
        answer += min;
        return answer;
        
    }
}
// 참조 : https://hellodavid.tistory.com/4
