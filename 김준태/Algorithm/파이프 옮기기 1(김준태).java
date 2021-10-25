package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_17070{

    // 방향을 저장하는 변수 DFS를 돌 때 +1 -1
    // 0 : 가로, 1 : 대각선, 2 : 세로
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 1, 0};

    static int answer = 0;
    static int N;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 초기화
        N = Integer.parseInt(br.readLine());
        int[][] tables = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                tables[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        recursive(1, 2, 0, tables);



        bw.write(answer + "");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void recursive(int x, int y, int nowWay, int[][] tables){
        // System.out.println(nowWay);
        // 종료 조건
        if(x > N || y > N || tables[x][y] == 1){
            // System.out.println("종료");
            return;
        }
        
        if(nowWay == 1){
            if(tables[x-1][y] == 1 || tables[x][y-1] == 1){
                return;
            }
        }
        
        // 도착했을 때
        if(x == N && y == N){
            // System.out.println("도착");
            answer++;
            return;
        }
        // 방문 처리
        
        // 재귀
        // 방향에 따라서 dfs 실행
        // 현재 방향에서 +1 0 -1로 방향을 바꿀 수 있음
        if(nowWay == 0){
            recursive(x + dx[nowWay], y+dy[nowWay], nowWay, tables);
            recursive(x + dx[nowWay+1], y+dy[nowWay+1], nowWay+1, tables);
        } else if(nowWay == 1){
            recursive(x + dx[nowWay], y+dy[nowWay], nowWay, tables);
            recursive(x + dx[nowWay+1], y+dy[nowWay+1], nowWay+1, tables);
            recursive(x + dx[nowWay-1], y+dy[nowWay-1], nowWay-1, tables);
        } else {
            recursive(x + dx[nowWay], y+dy[nowWay], nowWay, tables);
            recursive(x + dx[nowWay-1], y+dy[nowWay-1], nowWay-1, tables);
        }
        // 모든 경우의수를 위해 방문처리 초기화
    }
}
