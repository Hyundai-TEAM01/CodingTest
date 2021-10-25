import java.io.*;
import java.util.*;

public class Main {
	static int[][] h_move = { { 0, 1 }, { 1, 1 } };
	static int[][] v_move = { { 1, 0 }, { 1, 1 } };
	static int[][] c_move = { { 0, 1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		Deque<Integer> q = new ArrayDeque<Integer>();
		q.add(0); // i
		q.add(1); // j
		q.add(0); // 가로 0 세로 1 대각 2
		int answer = 0;
		
		if(map[N-1][N-1] == 1) {
			q.removeAll(q);
		}

		while (!q.isEmpty()) {
			int now_i = q.poll();
			int now_j = q.poll();
			int before_dir = q.poll();

			if (before_dir == 0) {
				for (int i = 0; i < h_move.length; i++) {
					int next_i = now_i + h_move[i][0];
					int next_j = now_j + h_move[i][1];
					if (0 <= next_i && next_i < N && next_j < N && 0 <= next_j && map[next_i][next_j] != 1) {
						if (i == 1 && (map[next_i - 1][next_j] == 1 || map[next_i][next_j - 1] == 1)) {
							continue;
						}
						
						if (next_i == N - 1 && next_j == N - 1) {
							answer++;
						} else {
							q.add(next_i);
							q.add(next_j);
							q.add(i * 2);
						}
					}
				}

			} else if (before_dir == 1) {
				for (int i = 0; i < v_move.length; i++) {
					int next_i = now_i + v_move[i][0];
					int next_j = now_j + v_move[i][1];
					if (0 <= next_i && next_i < N && next_j < N && 0 <= next_j && map[next_i][next_j] != 1) {
						if (i == 1 && (map[next_i - 1][next_j] == 1 || map[next_i][next_j - 1] == 1)) {
							continue;
						}
						
						if (next_i == N - 1 && next_j == N - 1) {
							answer++;
						} else {
							q.add(next_i);
							q.add(next_j);
							q.add(i + 1);
						}
					}
				}

			} else {
				for (int i = 0; i < c_move.length; i++) {
					int next_i = now_i + c_move[i][0];
					int next_j = now_j + c_move[i][1];
					if (0 <= next_i && next_i < N && next_j < N && 0 <= next_j && map[next_i][next_j] != 1) {
						if (i == 2 && (map[next_i - 1][next_j] == 1 || map[next_i][next_j - 1] == 1)) {
							continue;
						}

						if (next_i == N - 1 && next_j == N - 1) {
							answer++;
						} else {

							q.add(next_i);
							q.add(next_j);
							q.add(i);
						}
					}

				}
			}
		}

		System.out.println(answer);

	}

}
