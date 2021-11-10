import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int total;
    static int tempHouse;
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dy = { 0, 0, -1, 1 }; // 상하좌우
    static ArrayList<Integer> house = new ArrayList<>(); 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1][N+1];
        // 그래프 초기화
        graph = new boolean[N+1][N+1];
        for(int i = 0; i < N; i++){
            String row = br.readLine();
            for(int j = 0; j < N; j++){
                if (row.charAt(j) == '0'){
                    graph[i+1][j+1] = false;
                } else if (row.charAt(j) == '1'){
                    graph[i+1][j+1] = true;
                }
            }
        }
        
        for(int i = 1; i <= N; i++){
            for(int j = 1; j<= N; j++){
                if(!visited[i][j] && graph[i][j]){
                    total++;
                    tempHouse = 0;
                    dfs(i, j);
                    house.add(tempHouse);
                }
            }
        }
        
        Collections.sort(house);
        
        bw.write(total +"\n");
        for(int i = 0; i < house.size(); i++){
            bw.write(house.get(i) + "\n");
        }
        
        
        
        
        // // 테스트 출력
        // for(int i = 1; i <= N; i++){
        //     for(int j = 1; j<= N; j++){
        //         System.out.print(graph[i][j]);
        //     }
        //     System.out.println();
        // }
        
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    // 연결된 상하좌우 경로를 방문 처리 및 개수를 세어줌
    static void dfs(int x, int y){
        // 종료조건 - 상하좌우 잘 고려해야함
        if (x > N || x < 1 || y > N || y < 1){
            return;
        }
        if (visited[x][y] || !graph[x][y]){
            return;
        }
        
        // 재귀
        visited[x][y] = true;
        tempHouse++;
        for(int i = 0; i < 4; i++){
            dfs(x + dx[i], y + dy[i]);
        }
    }
}
