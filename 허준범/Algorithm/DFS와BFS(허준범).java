import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, V;
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 양방향 그래프
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N + 1]; // 방문처리 초기화
		bfs(V);

		System.out.println(sb);
	}

	// DFS 함수 정의
	public static void dfs(int V) {
		if (visited[V]) {
			return;
		}
		visited[V] = true;
		sb.append(V).append(" ");
		for (int i = 0; i < graph.get(V).size(); i++) {
			dfs(graph.get(V).get(i));
		}
	}

	// BFS 함수 정의
	public static void bfs(int V) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(V);
		visited[V] = true;

		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");

			for (int i = 0; i < graph.get(now).size(); i++) {
				if (!visited[graph.get(now).get(i)]) { // 방문하지 않았다면
					visited[graph.get(now).get(i)] = true;
					q.add(graph.get(now).get(i));
				}
			}

		}
	}
}
