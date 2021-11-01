import java.io.*;
import java.util.*;

public class Main {
	static int N,M,K, answer;
	static int[][] arr, position;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		position = new int[K][3];
		answer = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			position[i][0] = Integer.parseInt(st.nextToken());
			position[i][1] = Integer.parseInt(st.nextToken());
			position[i][2] = Integer.parseInt(st.nextToken());
		}
		
		
		boolean[] visited = new boolean[K];
		dfs(visited,0,new int[K]);
		System.out.println(answer);
		
	}
	
	static void dfs(boolean[] visited,int depth, int[] seq) {
		if(depth == K) {
			// 회전 순서 조합 완료
			int[][] temp_arr = new int[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					temp_arr[i][j] = arr[i][j];
				}
			}
			
			
			for(int i = 0; i < K; i++) {
				int start_x = position[seq[i]][0] - position[seq[i]][2] -1; 
				int start_y = position[seq[i]][1] - position[seq[i]][2] -1; 
				int end_x = position[seq[i]][0] + position[seq[i]][2] -1; 
				int end_y = position[seq[i]][1] + position[seq[i]][2] -1;
				// 회전
				// 0,1
				// 4,5
				int idx = 0;
				while(idx < (end_x - start_x)/2) {
					int now_x = start_x + idx;
					int now_y = start_y + idx;
					int before = temp_arr[now_x][now_y];
					int now = 0;
					
					now_y++;
					
					while(now_x != start_x + idx || now_y != start_y + idx) {
						if(now_x == start_x + idx && now_y < end_y - idx) {
							now = temp_arr[now_x][now_y];
							temp_arr[now_x][now_y] = before;
							before = now;
							now_y++;
						}else if(now_x < end_x -idx && now_y == end_y - idx) {
							now = temp_arr[now_x][now_y];
							temp_arr[now_x][now_y] = before;
							before = now;
							now_x++;
						}else if(now_x == end_x - idx && now_y > start_y + idx) {
							now = temp_arr[now_x][now_y];
							temp_arr[now_x][now_y] = before;
							before = now;
							now_y--;							
						}else if(now_y == start_y + idx && now_x > start_x+idx) {
							now = temp_arr[now_x][now_y];
							temp_arr[now_x][now_y] = before;
							before = now;
							now_x--;														
						}
					}
					
					temp_arr[now_x][now_y] = before;
					
					idx++; 
				}
			}
			// 회전 완료 후 row의 최소값 구하기
			for(int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = 0; j < M; j++) {
					sum += temp_arr[i][j];
				}
				if(sum < answer) {
					answer = sum;
				}
			}
			
			return;
		}
		
		
		for(int i = 0; i < K; i++) {
			if(!visited[i]) {
				visited[i] = true;
				seq[depth] = i;
				dfs(visited,depth+1,seq);
				visited[i] = false;
			}
		}
		
	}

}
