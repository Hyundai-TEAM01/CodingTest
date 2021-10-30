import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int[][] map;
	public static int n, m, d;
	public static int answer = 0;
	public static ArrayList<Integer> arrow = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// https://coding-factory.tistory.com/548
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		nCr(0, 0);
		System.out.println(answer);
	}

	// 궁수를 놓을 수 있는 경우의 수
	public static void nCr(int cnt, int start) {
		if (cnt == 3) {
			attack();
			return;
		}
		for (int i = start; i < m; i++) {
			arrow.add(i);
			nCr(cnt + 1, i + 1);
			arrow.remove(arrow.size() - 1);
		}
	}

	// 궁수의 위치가 정해지면 공격을 한다
	public static void attack() {
		int attackEnemy = 0;
		int castle = n; // 초기 성의 위치
		int[][] copyMap = new int[n][m]; // 방문된 곳 0으로 표시하기 위한 복사배열
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copyMap[i][j] = map[i][j];
			}
		}

		while (castle > 0) { // 성의 위치가 0보다 클 떄
			// 적이 들어가는 배열
			ArrayList<Integer[]> enemy = new ArrayList<>();

			for (int k = 0; k < arrow.size(); k++) { // 궁수만큼
				int min = Integer.MAX_VALUE;
				int[] pos = new int[2];
				for (int j = 0; j < m; j++) { // map 탐색, 왼쪽부터
					for (int i = castle - 1; i >= 0; i--) {
						if (copyMap[i][j] == 1) {
							// 적과의 거리
							int diff = Math.abs(castle - i) + Math.abs(arrow.get(k) - j);
							if (diff <= d) { // 공격할 수 있는 거리라면
								if (diff < min) { // 더 가까이 있는 적이 있다면
									min = diff;
									pos[0] = i;
									pos[1] = j;
								}
								break;
							}
						}
					}
				} // map 탐색 종료
				if (min != Integer.MAX_VALUE) { // 공격할 적이 있다면 enemy에 추가
					enemy.add(new Integer[] { pos[0], pos[1] });
				}
			}

			for (int i = 0; i < enemy.size(); i++) {
				// 궁수가 공격할 수 있는 enemy배열
				// 중복되는 적 고려할 것
				if (copyMap[enemy.get(i)[0]][enemy.get(i)[1]] != 0) {
					attackEnemy++;
					copyMap[enemy.get(i)[0]][enemy.get(i)[1]] = 0;
				}
			}
			castle--; // 성이 위로 올라감.
		} // End while

		// 처지한 적의 수 갱신
		if (attackEnemy > answer)
			answer = attackEnemy;
	}
}
