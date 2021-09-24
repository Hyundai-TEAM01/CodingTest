class Solution {
    
    static int[] visited;
    static int answer;
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new int[n];
        
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                answer++;
                dfs(i, computers);
            }
        }
        
        return answer;
    }
    
    public static void dfs(int depth, int[][] computers){
        visited[depth] = 1;
        
        for(int i = 0; i < computers.length; i++){
            if(visited[i] == 0 && computers[depth][i] == 1){
                dfs(i, computers);
            }
        }
    }
}
