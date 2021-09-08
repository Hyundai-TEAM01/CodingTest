import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        HashMap<Integer, Boolean> hash = new HashMap<>();
        int lostCount = lost.length;
        Arrays.sort(lost);
        
        for (int re : reserve){
            hash.put(re, true);
        }
        
        for(int i = 0; i < lost.length; i++){
            if(hash.get(lost[i]) != null){
                hash.remove(lost[i]);
                lost[i] = -1;
                lostCount--;
            }
        }
        
        for (int i = 0; i < lost.length; i++){
            int lostNum = lost[i];
            if(hash.get(lostNum-1) != null){
                hash.remove(lostNum - 1);
                lostCount--;
            } else {
                if(hash.get(lostNum+1) != null){
                    hash.remove(lostNum + 1);
                    lostCount--;
                }
            }
        }
        
        return n - lostCount;
    }
}
