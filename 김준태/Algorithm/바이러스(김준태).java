import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static int result = 0;
  static boolean[] visited;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    visited = new boolean[N+1];

    for(int i = 0; i <= N; i++){
      graph.add(new ArrayList<Integer>());
    }

    for(int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    // dfs 실행
    dfs(1);
    result--;

    bw.write(result + "");

    br.close();
    bw.flush();
    bw.close();
  }

  static void dfs(int depth){
    // 종료조건
    if(visited[depth]){
      return;
    }
    // 재귀
    visited[depth] = true;
    result++;
    for(int i = 0; i < graph.get(depth).size(); i++){
      dfs(graph.get(depth).get(i));
    }
  }
}
