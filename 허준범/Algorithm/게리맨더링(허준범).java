import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, K, Min, sum, partsum;
	public static int[] people; // 인구
	public static int[][] link;
	public static boolean[] check; // 선거구 나눌 용
	public static int[] temp;
	public static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// https://zunoxi.tistory.com/13
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N + 1];
		link = new int[N + 1][N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i < N + 1; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				int spot = Integer.parseInt(st.nextToken());
				link[i][spot] = 1;
			}
		}

		Min = Integer.MAX_VALUE;

		for (int i = 0; i < (N / 2) + 1; i++) {
			K = i;
			check = new boolean[N + 1];
			pick(1, 0);
		}

		if (Min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Min);
		}
	}

	public static void pick(int start, int cnt) {
		if (cnt == K) {
			sum = Integer.MAX_VALUE;
			temp = new int[N + 1];
			for (int i = 1; i < N + 1; i++) {
				if (check[i] == true) {
					temp[i] = 1;
				} else {
					temp[i] = 0;
				}
			}
			confirm();
			Min = Math.min(Min, sum);
			return;
		}

		for (int i = start; i < N + 1; i++) {
			check[i] = true;
			pick(i + 1, cnt + 1);
			check[i] = false;
		}
	}

	public static void confirm() {
		// 모든 지역구가 나눠지는지 확인하는 배열
		visited = new boolean[N + 1];
		int people1 = 0;
		int people2 = 0;
		for (int i = 1; i < N + 1; i++) {
			if (temp[i] == 1 && !visited[i]) {
				partsum = 0;
				gary(i);
				people1 = partsum;
				break;
			}
		}

		for (int i = 1; i < N + 1; i++) {
			if (temp[i] == 0 && !visited[i]) {
				partsum = 0;
				gary(i);
				people2 = partsum;
				break;
			}
		}

		// 한곳이라도 방문하지 않은곳이 있다면 턴 종료
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				return;
			}
		}
		sum = Math.abs(people2 - people1);
	}

	public static void gary(int x) {
		visited[x] = true;
		partsum = partsum + people[x];
		for (int i = 1; i < N + 1; i++) {
			// 방문했는지, 같은 지역구에 속했는지, 연결이 되어있는 지역인지 차례로 검사
			if (!visited[i] && temp[i] == temp[x] && link[i][x] == 1) {
				gary(i);
			}
		}
	}
}
