import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static BufferedWriter bw;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        for (int i = 1; i <= N; i++){
            Collections.sort(graph.get(i));
        }
        
        visited = new boolean[N+1];

        dfs(V);
        bw.newLine();

        visited = new boolean[N+1];
        
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(V);
        visited[V] = true;
        while(!qu.isEmpty()){
            int x = qu.poll();
            bw.write(x + " ");
            for(int i = 0; i < graph.get(x).size(); i++){
                int y = graph.get(x).get(i);
                if(!visited[y]){
                    qu.offer(y);
                    visited[y] = true;
                }
            }
        }
        

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int index) throws IOException{
        // 종료 조건
        if(visited[index]){
            return;
        }
        visited[index] = true;
        bw.write(index + " ");
        // 재귀
        for(int i = 0; i < graph.get(index).size(); i++){
            int x = graph.get(index).get(i);
            if(!visited[x]){
                dfs(x);
            }
        }
    }



}
