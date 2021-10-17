class Solution {
    
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        boolean target_exis = false;
        
        
        for (int i = 0; i < words.length; i++){
            if(words[i].equals(target)){
                target_exis = true;
                break;
            }
        }
        if(!target_exis){
            return 0;
        }
        
        // dfs 실행
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    
    
    static void dfs(String begin, String target, String[] words, int cnt){
        // 타겟과 같으면 종료
        if(begin.equals(target)){
            answer = cnt;
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(visited[i]){
                continue;
            }
            
            int k = 0;
            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)){
                    k++;
                }
            }
            
            // 한글자 빼고 모두 같은 경우
            if(k == begin.length() - 1){
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
