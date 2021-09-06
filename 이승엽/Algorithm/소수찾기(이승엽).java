import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] isNotPrime, visited;
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        
        // 소수 목록 구하기
        isNotPrime = new boolean[1000000];
        isNotPrime[0] = isNotPrime[1] = true;
        for(int i = 2; i < isNotPrime.length; i++){
            if(!isNotPrime[i]){
                for(int j = i+i; j < isNotPrime.length; j += i){
                    isNotPrime[j] = true;
                }
            }
        }
        
        char[] arr = numbers.toCharArray();
        dfs(arr,0,arr.length,"");
        
        
        answer = set.size();
        return answer;
    }
    
    static void dfs(char[] arr, int depth, int length, String before){
        if(depth == length){
            return;
        }
        
        for(int i = 0; i < length; i++){
            if(!visited[i]){
                 StringBuilder sb = new StringBuilder();
                sb.append(before);
                sb.append(arr[i]);
                
                if(!sb.toString().equals("") &&!sb.toString().startsWith("0")){
                    try{
                        int temp = Integer.parseInt(sb.toString());
                        if(!isNotPrime[temp])
                            set.add(temp);
                    }catch(Exception e){
                        
                    }
                }
                
                visited[i] = true;
                if(arr[i] != '0' || !before.equals("")){
                     dfs(arr,depth+1,length,sb.toString());
                }else{
                    dfs(arr,depth+1,length,"");
                }
                visited[i] = false;
            }
        }
        
    }
}




//import java.util.*;
//class Solution {
//    static boolean[] visited = new boolean[8];
//    public int solution(String numbers) {
//		int answer = 0;
//        
//        char[] chars = numbers.toCharArray();
//		Arrays.sort(chars);
//		String temp = "";
//		for (int i = chars.length - 1; i >= 0; i--) {
//			temp += chars[i];
//		}
//        // 소수 구하기
//		boolean[] prime = new boolean[Integer.parseInt(temp) + 1];
//		prime[0] = prime[1] = true;
//		for (int i = 2; i < prime.length; i++) {
//            if(prime[i]) {
//				continue;
//			}
//			for (int j = i + i; j < prime.length; j += i) {
//				prime[j] = true;
//			}
//		}
//        
//		HashSet<Integer> set = new HashSet<Integer>();
//		func(numbers, 1, set, null);
//
//		for (int n : set) {
//			if (!prime[n]) {
//				answer++;
//			}
//		}
//        return answer;
//    }
//    	static void func(String str, int depth, HashSet<Integer> set, String before) {
//		if (str.length() < depth) {
//			return;
//		}
//
//		for (int i = 0; i < str.length(); i++) {
//			if (!visited[i]) {
//				visited[i] = true;
//				StringBuilder sb = new StringBuilder();
//                
//				if(before != null) {	
//					sb.append(before);				
//				}
//				sb.append(str.charAt(i));	
//                
//                set.add(Integer.parseInt(sb.toString()));
//                
//				func(str,depth+1,set,sb.toString());
//                
//				visited[i] = false;
//			}
//		}
//	}
//}