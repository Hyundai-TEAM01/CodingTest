import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String str : participant){
            if(map.get(str) != null){
                map.put(str,map.get(str)+1);
            }else{
                map.put(str,1);
            }
        }
        for(String str : completion){
            if(map.get(str) > 1){
                map.put(str,map.get(str)-1);
            }else{
                map.remove(str);
            }
        }
        
        for(String str : map.keySet()){
            answer += str;
        }
        
        
        return answer;
    }
}

/* 기존에 작성한 코드

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> map = new HashMap<>();

        for(String str : participant){
            if(map.putIfAbsent(str,1) != null){ // 해당 key 값이 없으면 null return, 아니면 value 값 return
                map.replace(str,map.get(str)+1); // 값 수정
            }
        }

        for(String str : completion) {
            if (map.get(str) > 1) {
                map.replace(str, map.get(str) - 1);
            } else{
                map.remove(str);
            }
        }

        for(String str : map.keySet()){
            answer += (str +"");
        }
        
        
        return answer;
    }
}
*/
