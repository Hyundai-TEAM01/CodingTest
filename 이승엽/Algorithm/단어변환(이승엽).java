import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean check = false;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(target)){
                check = true;
                break;
            }
        }
        if(!check){
            return 0;
        }
        
        Deque<Pair> q = new ArrayDeque();
        q.add(new Pair(begin,0));
        while(!q.isEmpty()){
            Pair now = q.poll();
            if(now.val.equals(target)){
                answer = now.depth;
                break;
            }
            
            for(int i = 0; i < words.length; i++){
                if(check(now.val,words[i])){
                    q.add(new Pair(words[i],now.depth+1));
                }
            }
        }
        
        return answer;
    }
    
    static class Pair{
        String val;
        int depth;
        public Pair(String val, int depth){
            this.val = val;
            this.depth = depth;
        }
    }
    
    static boolean check (String str1, String str2){
        int check = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                check++;
            }
        }
        if(check == 1){
            return true;
        }else{
            return false;
        }
    }
}