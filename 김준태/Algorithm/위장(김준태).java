import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesMap = new HashMap<>();
        // HashMap<종류, 개수>>
        for (int i = 0; i < clothes.length; i++){
            // 종류 clothes[i][1]
            // 이름 clothes[i][0]
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1] , 0) + 1);
        }
        // 한종류만 선택해서 입을 수 있기 때문에 A*B 가 아닌 (A+1)*(B+1)이 되도록 함.
        for (String key : clothesMap.keySet()){
            answer *= (clothesMap.get(key) + 1);
            // System.out.println(clothesMap.get(key)+1);
        }
        answer -= 1;
        
        return answer;
    }
}
