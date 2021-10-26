import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int[][] map;
	static int N, M, D, answer, min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		min = N;
		map = new int[N][M];
		int sum = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];

				if (min > i && map[i][j] == 1) {
					min = i;
				}
			}
		}

		visited = new boolean[M];

		if (sum > 3) {
			dfs(0, 0, new int[3]);
		}else if(1 <= sum || sum <= 3) {
			answer = sum;
		}
		System.out.println(answer);

	}

	static void dfs(int val, int start, int[] arr) {
		if (val == 3) {
			// 궁수 위치 조합 완료 게임 실행
			int[][] temp_map = new int[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp_map[i][j] = map[i][j];
				}
			}

			int now = N;
			Deque<Integer> q = new ArrayDeque<Integer>();
			int kill = 0;
			while (now > min) {
				for (int i = 0; i < 3; i++) {
					int p_y = arr[i];

					for(int d = 1; d <= D; d++) {
						int x = now - 1;
						int y = p_y - d + 1;
						boolean c = false;
						
						for(int a = 0; a < d; a++) {
							if(0 <= x && 0 <= y && y < M && temp_map[x][y] == 1) {
								q.add(x);
								q.add(y);
								c = true;
								break;
							}
							
							x--;
							y++;
						}
						
						
						if(c) {
							break;
						}
						x++;
						y--;
						
						for(int a = 0; a < d-1; a++) {
							x++;
							y++;

							if(0 <= x && 0 <= y && y < M && temp_map[x][y] == 1) {
								q.add(x);
								q.add(y);
								c = true;
								break;
							}
						}
						
						if(c) {
							break;
						}
						
					}
				}

				while (!q.isEmpty()) {
					int x = q.poll();
					int y = q.poll();
					if (temp_map[x][y] == 1) {
						temp_map[x][y] = 0;
						kill++;
					}
				}
				now--;

			}
			answer = Math.max(answer, kill);
			return;
		}

		for (int i = start; i < M; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[val] = i;
				dfs(val + 1, i, arr);
				visited[i] = false;
			}
		}
	}
}