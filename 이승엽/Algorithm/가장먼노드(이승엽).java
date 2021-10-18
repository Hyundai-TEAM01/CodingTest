import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 1;
        
        ArrayList<Integer>[] g = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++){
            g[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edge.length; i++){
            g[edge[i][0]].add(edge[i][1]);
            g[edge[i][1]].add(edge[i][0]);
        }
        
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        
        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(1,0));
        
        int max_depth = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i : g[now.v]){
                if(!visited[i]){
                    visited[i] = true;
                    if(max_depth < now.depth+1){
                        max_depth = now.depth+1;
                        answer = 1;
                    }else if(max_depth == now.depth+1){
                        answer++;
                    }
                    q.add(new Node(i,now.depth+1));
                }
            }
        }
        
        
        return answer;
    }
    
    static public class Node{
        int v, depth;
        public Node(int v, int depth){
            this.v = v;
            this.depth = depth;
        }
    }
}