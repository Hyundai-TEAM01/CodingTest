import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[][] players;
	public static int[] lineUp = new int[10];
	public static boolean[] visited = new boolean[10];
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		players = new int[n + 1][10];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				players[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1번 선수 4번 타자 지명
		lineUp[4] = 1;
		visited[4] = true;
		// 타자 순번 지정
		makeOrder(2);
		System.out.println(answer);
	}

	public static void makeOrder(int depth) {
		if (depth == 10) {
			playBaseBall(); // 야구게임시작
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				lineUp[i] = depth;
				makeOrder(depth + 1);
				visited[i] = false;
			}
		}
	}

	public static void playBaseBall() {
		int score = 0;
		int startPlayer = 1; // 이닝시작타자순번
		boolean[] base; // base에 있는 타자
		// n번째 이닝
		for (int i = 1; i <= n; i++) {
			int out = 0; // 아웃된 사람 수
			base = new boolean[4]; // base 초기화

			// 아웃카운트가 3개일 때까지 반복
			finish: while (true) {
				for (int j = startPlayer; j <= 9; j++) {
					int hit = players[i][lineUp[j]]; // j번째 타자의 행동

					if (hit == 0) { // 아웃
						out++;
					}
					// 1루타
					else if (hit == 1) {
						for (int k = 3; k >= 1; k--) {
							if (base[k]) {
								if (k == 3) { // 3루에 있는 선수 홈으로
									score++;
									base[k] = false;
									continue;
								}
								// 1, 2루에 있는 선수들 진루
								base[k] = false;
								base[k + 1] = true;
							}
						}
						base[1] = true; // 홈에서 1루로 진루
					}
					// 2루타
					else if (hit == 2) {
						for (int k = 3; k >= 1; k--) {
							if (base[k]) {
								if (k == 3 || k == 2) { // 3루, 2루 선수 홈으로
									score++;
									base[k] = false;
									continue;
								}
								// 1루에 있는 선수 진루
								base[k] = false;
								base[k + 2] = true;
							}
						}
						base[2] = true; // 홈에서 2루로 진루
					}
					// 3루타
					else if (hit == 3) {
						for (int k = 3; k >= 1; k--) {
							if (base[k]) { // 홈 제외 모든 선수 홈으로
								score++;
								base[k] = false;
							}
						}
						base[3] = true; // 홈에서 3루로 진루
					}
					// 홈런
					else if (hit == 4) {
						for (int k = 3; k >= 1; k--) {
							if (base[k]) { // 주자들 모두 홈으로
								score++;
								base[k] = false;
							}
						}
						score++; // 홈런 타자 1점 추가
					}
					if (out == 3) { // 아웃 카운트가 3개면
						// 다음 이닝 시작타자 설정
						startPlayer = j + 1;
						if (startPlayer == 10) {
							startPlayer = 1;
						}
						break finish;
					}
				} // End for

				// 이닝이 다 끝나서 1번부터 시작
				startPlayer = 1;
			} // End while
		} // End for
		answer = Math.max(answer, score);
	} // End playBaseBall

}
