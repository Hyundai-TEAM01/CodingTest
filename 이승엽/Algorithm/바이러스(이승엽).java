import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int computer = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        
        int[][] map = new int[computer][computer];
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            map[x][y] = 1;
            map[y][x] = 1;
        }
        boolean[] visited = new boolean[computer];
        
        int answer = 0;
        ArrayDeque<Integer>q = new ArrayDeque<>();
        
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 0; i < computer; i++){
                if(!visited[i] && map[now][i] == 1){
                    q.add(i);
                    visited[i] = true;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}