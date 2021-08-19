import java.util.*;

// 제 코드
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> peoples = new HashMap<>();
        for(String parti : participant) {
            if(peoples.containsKey(parti)) {
                peoples.put(parti, peoples.get(parti) + 1);
            } else {
                peoples.put(parti, 1);
            }
        }
        
        for(String comple : completion) {
            if(peoples.get(comple) == 1) {
                peoples.remove(comple);
            } else {
                peoples.put(comple, peoples.get(comple) - 1);
            }
        }
        
        for(String peo : peoples.keySet()) {
            answer = peo;    
        }
        
        return answer;
    }
}

// 다른 사람 코드(getOrDefault) 라는 게 있네요?
// import java.util.HashMap;

// class Solution {
//    public String solution(String[] participant, String[] completion) {
//          String answer = "";
//         HashMap<String, Integer> hm = new HashMap<>();
//         for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
//         for (String player : completion) hm.put(player, hm.get(player) - 1);

//         for (String key : hm.keySet()) {
//             if (hm.get(key) != 0){
//                 answer = key;
//             }
//         }
//         return answer;
//     }
// }