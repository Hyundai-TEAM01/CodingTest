import java.util.*;
class Solution {
    
    public int solution(String[][] clothes) {
        int answer = clothes.length; // 옷 종류가 1개이면 그냥 갯수 반환
        
        Map<String, ArrayList<String>> wears = new HashMap<>();
        
        for(int i=0; i < clothes.length; i++) {
            String[] cloth = clothes[i];
            if(!wears.containsKey(cloth[1])) {
                wears.put(cloth[1], new ArrayList<String>());
            }
               wears.get(cloth[1]).add(cloth[0]);
        }
        if(wears.size() > 1) { // 2개 이상의 종류가 있다면
            int result = 1;
            for(String key : wears.keySet()) { // 모든 종류의 옷
                int n = wears.get(key).size(); 
                result *= n + 1;    // 경우의 수 *= (다른 종류 옷의 갯수 + 그 옷 선택 안한 경우)
            }

           answer = result - 1; // 다 안입었을 경우 뺴기
        }
                   
        return answer;
    }
}