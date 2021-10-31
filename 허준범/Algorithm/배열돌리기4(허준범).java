package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17406 {
	public static int N, M, K;
	public static int[][] map;
	public static int[][] rotateInfo;
	public static int[] order;
	public static boolean[] visited;
	public static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		rotateInfo = new int[K][3];
		order = new int[K];
		visited = new boolean[K];

		answer = Integer.MAX_VALUE;

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rotateInfo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		makeOrder(0);
		System.out.println(answer);
	}

	public static void makeOrder(int depth) {
		if (depth == K) {
			rotateMap();
			return;
		}

		for (int i = 0; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				order[depth] = i;
				makeOrder(depth + 1);
				visited[i] = false;
			}
		}
	}

	public static void rotateMap() {
		int[][] copyMap = new int[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				copyMap[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < K; i++) {
			int r = rotateInfo[order[i]][0];
			int c = rotateInfo[order[i]][1];
			int s = rotateInfo[order[i]][2];

			int x1 = r - s;
			int y1 = c - s;
			int x2 = r + s;
			int y2 = c + s;
			rotate(copyMap, x1, y1, x2, y2);
		}
		calMin(copyMap);
	}

	public static void rotate(int[][] copyMap, int x1, int y1, int x2, int y2) {
		if (x1 == x2 && y1 == y2) {
			return;
		}
		int temp = copyMap[x1][y1];
		// 왼쪽
		for (int i = x1; i < x2; i++) {
			copyMap[i][y1] = copyMap[i + 1][y1];
		}
		// 아래
		for (int i = y1; i < y2; i++) {
			copyMap[x2][i] = copyMap[x2][i + 1];
		}
		// 오른쪽
		for (int i = x2; i > x1; i--) {
			copyMap[i][y2] = copyMap[i - 1][y2];
		}
		// 위쪽
		for (int i = y2; i > y1; i--) {
			copyMap[x1][i] = copyMap[x1][i - 1];
		}
		copyMap[x1][y1 + 1] = temp;
		rotate(copyMap, x1 + 1, y1 + 1, x2 - 1, y2 - 1);
	}

	// 최솟값 구하기
	public static void calMin(int[][] copyMap) {
		for (int i = 1; i < N + 1; i++) {
			int total = 0;
			for (int j = 1; j < M + 1; j++) {
				total += copyMap[i][j];
			}
			answer = Math.min(answer, total);
		}
	}
}
