// 참고 : https://fbtmdwhd33.tistory.com/252
class Solution {
    
    static boolean visited[] = new boolean[8];
    static char friends[] = {'A','C','F','J','M','N','R','T'};
    
    static int answer;
    
    public int solution(int n, String[] data) {
        StringBuilder sb = new StringBuilder();
        answer = 0;
        dfs(0, sb, data);
        
        return answer;
    }
    
    public static void dfs(int idx, StringBuilder sb, String[] data){
        if(idx == friends.length){
            if(check(sb, data)){
                answer++;
            }
            return;
        }
        
        for(int i = 0; i < friends.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            
            sb.append(String.valueOf(friends[i]));
            dfs(idx + 1, sb, data);
            visited[i] = false;
            sb.delete(idx, friends.length);
            
        }
    }
    
    public static boolean check(StringBuilder sb, String[] data){
        for (int i = 0; i < data.length; i++){
            int gap = Math.abs(sb.indexOf(String.valueOf(data[i].charAt(0))) - sb.indexOf(String.valueOf(data[i].charAt(2)))) - 1;
            int condition_gap = data[i].charAt(4) - '0';
            
            switch(data[i].charAt(3)){
                case '=' :
                    if(gap != condition_gap) return false;
                    break;
                case '>':
                    if(gap <= condition_gap) return false;
                    break;
                case '<':
                    if(gap >= condition_gap) return false;
                    break;
            }
        }
        return true;
    }
}
