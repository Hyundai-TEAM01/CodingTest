import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static int answer = 0;
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		visited = new boolean[n + 1];
		virus(1);

		System.out.println(answer);
	}

	public static void virus(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < graph.get(now).size(); i++) {
				if (!visited[graph.get(now).get(i)]) {
					visited[graph.get(now).get(i)] = true;
					q.add(graph.get(now).get(i));
					answer++;
				}
			}
		}
	}
}
