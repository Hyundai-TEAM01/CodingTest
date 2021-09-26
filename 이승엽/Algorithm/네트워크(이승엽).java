import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i = 0; i < computers.length; i++){
            if(visited[i]){
               continue; 
            }
            rec(computers,i);
            answer++;
        }
    
        return answer;
    }
    
    static void rec(int[][] computers, int start){
        
        for(int i = 0; i < computers[start].length; i++){
            if(i == start){
                continue;
            }
            
            if(computers[start][i] == 0){
                continue;
            }
            
            if(!visited[i] && computers[start][i] == 1){
                visited[i] = true;
                rec(computers,i);
            }
        }
    }

}