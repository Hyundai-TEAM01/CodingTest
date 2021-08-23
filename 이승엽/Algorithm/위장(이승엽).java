import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();
        
		for(int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
		}
        
		if(map.size() == 1) {
			answer = map.get(clothes[0][1]);
		}else {
			for(String str : map.keySet()) {
				answer *= (map.get(str)+1);
			}
			answer--;
		}
        return answer;
    }
}




// 이전 풀이
/*import java.util.*; 

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1, cnt = 0;

        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length;i++){
            String cate = clothes[i][1];
            if(map.putIfAbsent(cate,1) != null){
                map.replace(cate,map.get(cate)+1);
            }else{
                cnt++;
            }
        }
        
        if(cnt == 1){
           answer = map.get(clothes[0][1]);
        }else{ // 종류 2개 이상
            for(String str : map.keySet()){
                answer *= (map.get(str)+1);
            }
            answer--;
        }
        
        
        return answer;
    }
}

*/