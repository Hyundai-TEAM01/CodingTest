import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        
        for(int i = 1; i < N+1; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            arr[first].add(second);
            arr[second].add(first);
        }
        
        for(int i = 1; i < N+1; i++) {
        	arr[i].sort(null);
        }
        
        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        dfs(arr,visited,start);
        
        System.out.println();
        
        bfs(arr,new boolean[N+1],start);
        
    }
    
    static void dfs(ArrayList<Integer>[] arr, boolean[] visited,int start){
    	System.out.print(start+ " ");
 
        for(int k : arr[start]){
            if(!visited[k]){
                visited[k] = true;
                dfs(arr,visited,k);
            }
        }

    }
    
    static void bfs(ArrayList<Integer>[] arr, boolean[] visited, int start){
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()) {
        	int now = q.poll();
        	System.out.print(now+" ");
        	for(int k : arr[now]) {
        		if(!visited[k]) {
        			q.add(k);
        			visited[k] = true;
        		}
        	}
        }
    }
}