import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] board;
	public static int min;
	public static int[] remain = { 0, 5, 5, 5, 5, 5 }; // 각 색종이의 남은 개수

	public static void main(String[] args) throws Exception {
		// https://moonsbeen.tistory.com/32
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		board = new int[10][10];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bp(0, 0, 0); // 0,0부터 오른쪽 아래로 이동하며 색종이를 덮어 나간다.

		if (min == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(min);
	}

	public static void bp(int x, int y, int count) {
		if (x == 9 && y == 10) { // 마지막에 도달하면
			min = Math.min(min, count);
			return;
		}
		if (y == 10) { // 오른쪽으로 이동하다가 범위 벗어나면 아래로 이동
			bp(x + 1, 0, count);
			return;
		}
		if (count >= min) // 현재 count가 최소값보다 크다면 더 이상 계산할 필요가 없다.
			return;

		if (board[x][y] == 1) {
			for (int j = 5; j >= 1; j--) { // 제일 큰 색종이부터
				if (remain[j] > 0 && isAttach(x, y, j)) { // 색종이 붙일 수 있다면
					attach(x, y, j); // 현재 위치에 j크기의 색종이를 붙인다.
					remain[j]--; // 해당 색종이 감소
					bp(x, y + 1, count + 1);
					detach(x, y, j); // 붙였던 색종이 다시 떼어준다.
					remain[j]++; // 해당 색종이를 다시 떼어냈으므로 증가시킨다.
				}
			}
		} else { // board[x][y]가 0인 경우에는 오른쪽으로
			bp(x, y + 1, count);
		}
	}

	// x, y 위치에서부터 size만큼의 색종이를 붙이는 과정
	public static void attach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				board[i][j] = 2; // 색종이 붙였음을 표시
			}
		}
	}

	// x, y 위치에서부터 size만큼의 색종이를 떼는 과정
	public static void detach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				board[i][j] = 1; // 색종이 붙였음을 표시
			}
		}
	}

	// x, y 위치로부터 size만큼의 색종이를 붙일 수 있는 지 확인하는 과정
	public static boolean isAttach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i >= 10 || j >= 10)
					return false;
				if (board[i][j] != 1)
					return false;
			}
		}
		return true;
	}
}
