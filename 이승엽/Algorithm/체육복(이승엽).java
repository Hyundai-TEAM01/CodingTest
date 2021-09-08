import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        ArrayList<Integer> lostli = new ArrayList<>();
        ArrayList<Integer> reserveli = new ArrayList<>();
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int i = 0;
        int j = 0;
        while(i < lost.length && j < reserve.length){
            if(lost[i] == reserve[j]){
                i++;
                j++;
            }else if(lost[i] < reserve[j]){
                lostli.add(lost[i++]);
            }else{
                reserveli.add(reserve[j++]);
            }
        }
        while(i != lost.length){
            lostli.add(lost[i++]);
        }
        while(j != reserve.length){
            reserveli.add(reserve[j++]);
        }
        answer += n - lostli.size();
        // 1잃어버림 2여분 3잃어버림 4여분 5잃어버림
       int k = 0;
       while(k < lostli.size()){
            if(lostli.get(k) == 1){
                if(reserveli.contains(2)){
                    answer++;
                    reserveli.remove(reserveli.indexOf(2));
                }
            }else if(lostli.get(k) == n){
                if(reserveli.contains(n-1)){
                    answer++;
                    reserveli.remove(reserveli.indexOf(n-1));
                }
            }else{
                if(reserveli.contains(lostli.get(k)-1)){
                    answer++;
                   reserveli.remove(reserveli.indexOf(lostli.get(k)-1));
                }else if(reserveli.contains(lostli.get(k)+1)){
                    answer++;
                   reserveli.remove(reserveli.indexOf(lostli.get(k)+1));
                }
            }
         k++;   
        }
        
    
        
        return answer;
    }
}