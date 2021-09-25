import java.util.*;

class Node {
    int x, y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int solution(int n, int[][] computers) {
        // 질문하기 봄..
        int answer = 0;
        
        // 1인 곳 bfs
        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                if(computers[i][j] == 1) {
                    bfs(computers, i, j, n);
                    answer++;
                }
            }
            
        }
        
        return answer;
    }
    
    public static void bfs(int[][] computers, int i, int j, int n) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j)); 
        
        // 연결된 노드 처리
        while(!q.isEmpty()) {
            // a -> b
            Node node = q.remove();
            int x = node.x;
            int y = node.y;
            visited.add(y);
            
            // b -> c
            for(int k=0; k < n; k++) {
                if(computers[y][k] == 1) {
                    if(!visited.contains(k))
                        q.add(new Node(y, k));
                    computers[y][k] = 0;
                }
            }
        }
    }
}