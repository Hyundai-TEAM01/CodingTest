import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] map;
	public static int[][][] dp;
	public static int HOR = 0;
	public static int VER = 1;
	public static int DIA = 2;

	public static void main(String[] args) throws Exception {
		// https://www.youtube.com/watch?v=tTclXbQbJTA
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1][3];

		// 입력
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 모서리 1로 초기화
		for (int i = 0; i < N + 1; i++) {
			map[i][0] = 1;
		}
		for (int j = 0; j < N + 1; j++) {
			map[0][j] = 1;
		}
		// 처음 파이프
		dp[1][2][0] = 1;

		// 수평, 수직, 대각
		int[] di = { 0, -1, -1 };
		int[] dj = { -1, 0, -1 };

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (map[i][j] == 1)
					continue;

				for (int k = 0; k < 3; k++) {
					// 이전 경로
					int bi = i + di[k];
					int bj = j + dj[k];

					if (map[bi][bj] == 1)
						continue;

					// 수평일 때
					if (k == HOR) {
						dp[i][j][HOR] += dp[bi][bj][HOR];
						dp[i][j][HOR] += dp[bi][bj][DIA];
					}
					// 수직일 때
					else if (k == VER) {
						dp[i][j][VER] += dp[bi][bj][VER];
						dp[i][j][VER] += dp[bi][bj][DIA];
					}
					// 대각선일 때
					else {
						if (map[i][j - 1] == 1)
							continue;
						if (map[i - 1][j] == 1)
							continue;

						dp[i][j][DIA] += dp[bi][bj][HOR];
						dp[i][j][DIA] += dp[bi][bj][VER];
						dp[i][j][DIA] += dp[bi][bj][DIA];
					}
				}
			}
		}

		int r = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
		System.out.println(r);
	}
}
