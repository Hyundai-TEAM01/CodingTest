import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static int N;
	public static ArrayList<Integer> num;
	public static ArrayList<Character> op;
	public static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		// https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-16637-%EA%B4%84%ED%98%B8-%EC%B6%94%EA%B0%80%ED%95%98%EA%B8%B0-java
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		num = new ArrayList<>();
		op = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			if (arr[i] >= '0' && arr[i] <= '9') {
				num.add(Character.getNumericValue(arr[i]));
			} else {
				op.add(arr[i]);
			}
		}

		dfs(0, num.get(0));
		System.out.println(answer);
	}

	public static void dfs(int depth, int sum) {
		if (depth == op.size()) {
			answer = Math.max(answer, sum);
			return;
		}
		// 괄호 치고 넘기기
		// (3 + 8) x 7
		dfs(depth + 1, calculate(sum, num.get(depth + 1), op.get(depth)));

		if (depth + 2 <= op.size()) {
			// 괄호 안 치고 넘기기
			// 3 + (8 x 7)
			dfs(depth + 2, calculate(sum, calculate(num.get(depth + 1), num.get(depth + 2), op.get(depth + 1)),
					op.get(depth)));
		}
	}

	public static int calculate(int a, int b, char op) {
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}
}
