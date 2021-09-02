import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // https://en.wikipedia.org/wiki/H-index 내용 
        // 먼저 f 의 값을 가장 큰 값에서 가장 낮은 값으로 정렬합니다.
        // 그런 다음 f 가 위치 보다 크거나 같은 마지막 위치를 찾습니다 ( h를 이 위치라고 함).
        int answer = 0; // 초기 값 0으로 설정
        int n = citations.length; // 논문 수
        
        // 내림차순 정렬
        Integer[] f = Arrays.stream(citations).boxed().toArray(Integer[]::new);       
        Arrays.sort(f, Collections.reverseOrder());
        
        // 예시
        // f(x):h-index -> f(x-1):h-index+1 -> f(x-2):h-index+2 -> ...
        // 10:1 -> 8:2 -> 5:3 -> 4:(4) -> 3:5 → h -index=4
        for(int i=0, hIndex = 1; i < n; i++, hIndex++) {
            if(f[i] >= hIndex)
                answer = hIndex;
            else
                break;
        }
        
        return answer;
    }
}