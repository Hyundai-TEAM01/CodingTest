import java.io.*;
import java.util.*;

public class Main {
	static int[][] player;
	static int answer;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		player = new int[N][9];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] visited = new boolean[9];
		visited[0] = true;
		play(visited, 0, new int[9]);
		System.out.println(answer);
	}

	static void play(boolean[] visited, int depth, int[] arr) {
		if (depth == 9) {
			// 선수 배치 완료
			int out = 0;
			int score = 0;
			int idx = 0;
			int round = 0;
			int[] ground = new int[4];

			while (round < N) {
				while (out < 3) {
					if (player[round][arr[idx % 9]] == 0) {
						out++;
					} else {
						if (player[round][arr[idx % 9]] == 1) { // 안타
							for (int i = 2; i >= 0; i--) {
								if (ground[i] == 1) {
									ground[i + 1]++;
									ground[i]--;
								}
							}
							ground[0]++;

						} else if (player[round][arr[idx % 9]] == 2) { // 2루타
							for (int i = 2; i >= 0; i--) {
								if (ground[i] == 1) {
									if (i + 2 >= 3) {
										ground[3]++;
										ground[i]--;
									} else {
										ground[i + 2]++;
										ground[i]--;
									}
								}
							}
							ground[1]++;
						} else if (player[round][arr[idx % 9]] == 3) { // 3루타
							for (int i = 2; i >= 0; i--) {
								if (ground[i] == 1) {
									ground[3]++;
									ground[i]--;

								}
							}
							ground[2]++;
						} else if (player[round][arr[idx % 9]] == 4) {
							for (int i = 2; i >= 0; i--) {
								if (ground[i] == 1) {
									ground[3]++;
									ground[i]--;
								}
							}
							ground[3]++;
						}

						score += ground[3];
						ground[3] = 0;
					}
					idx++;
				}
				round++;
				out = 0;
				ground = new int[4];
			}

			if (score > answer) {
				answer = score;
			}
			
			return;
		}

		if (depth == 3) {
			arr[depth] = 0;
			play(visited, depth + 1, arr);
		} else {
			for (int i = 0; i < 9; i++) {
				if (!visited[i]) {
					visited[i] = true;
					arr[depth] = i;
					play(visited, depth + 1, arr);
					visited[i] = false;
				}
			}
		}
	}

}
