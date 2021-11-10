import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';

			}
		}
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		boolean[][] visited = new boolean[N][N];
		
		int[] mx = {-1,1,0,0};
		int[] my = {0,0,1,-1};
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					ArrayDeque<Integer> q = new ArrayDeque<Integer>();
					q.add(i);
					q.add(j);
					
					int cnt = 1;
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						int x = q.poll();
						int y = q.poll();
						
						for(int k = 0; k < 4; k++) {
							int next_x = x+mx[k];
							int next_y = y+my[k];
							
							if(next_x <0 || next_x >= N || next_y < 0 || next_y >= N) {
								continue;
							}
							if(!visited[next_x][next_y] && map[next_x][next_y] == 1) {
								visited[next_x][next_y] = true;
								q.add(next_x);
								q.add(next_y);
								cnt++;
							}
						}
					}
					arr.add(cnt);
				}
			}
		}
		arr.sort(null);
		System.out.println(arr.size());
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

}