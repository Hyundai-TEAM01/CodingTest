import java.util.*;
class Solution {
    static HashSet<String> li;
    static String[] str = {"A", "C", "F", "J", "M", "N", "R", "T"};
    public int solution(int n, String[] data) {
        int answer = 0;
        li = new HashSet<>();
        boolean[] visited = new boolean[8];
        // 생성가능한 모든 문자열 생성
        createString(visited,"");

        HashSet<String> temp = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            String now = data[i];
            Iterator iter = null;
            HashSet<String> now_set = null;
            
            if(i % 2  == 0){
                iter = li.iterator();
                temp = new HashSet<>();
                now_set = temp;
            }else{
                iter = temp.iterator();
                li = new HashSet<>();
                now_set = li;
            }
            
            if(!iter.hasNext()){
                return 0;
            }
             
            while(iter.hasNext()){
                String s = (String)iter.next();
                if(now.charAt(3) == '='){
                    if(Math.abs(s.indexOf(now.charAt(0))-s.indexOf(now.charAt(2))) == (now.charAt(4)-'0'+1)){
                        now_set.add(s);
                    }
                    
                }else if(now.charAt(3) == '<'){
                    if(Math.abs(s.indexOf(now.charAt(0))-s.indexOf(now.charAt(2))) < (now.charAt(4)-'0'+1)){
                       now_set.add(s);
                    }

                }else{
                    if(Math.abs(s.indexOf(now.charAt(0))-s.indexOf(now.charAt(2))) > (now.charAt(4)-'0'+1)){
                        now_set.add(s);
                    }
                }    
            }
            
        }
        
        if(n % 2 == 0){
            return li.size();
        }else{
            return temp.size();
        }
    }
    
    static void createString(boolean[] visited,String s){
        if(s.length() == 8){
            li.add(s);
        }
        
        for(int i = 0; i < 8; i++){
            if(!visited[i]){
                visited[i] = true;
                createString(visited,s+str[i]);
                visited[i] = false;
            }
        }
    }
}