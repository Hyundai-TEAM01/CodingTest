import java.util.*;

class Solution {
    
    public static char[] prior = {'+', '-', '*'
    };
    public static boolean[] check = new boolean[3];
    public static ArrayList<Long> nums = new ArrayList<>();
    public static ArrayList<Character> ops = new ArrayList<>();
    public static long answer;
    
    public long solution(String expression) {
        // https://codingjuny.tistory.com/42#recentEntries
        answer = 0;
        
        String num = "";
        for(int i=0; i < expression.length(); i++) {
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                num += expression.charAt(i); // num = "100"
            } else {
                nums.add(Long.parseLong(num));
                num = "";
                ops.add(expression.charAt(i));
            }
        }
        nums.add(Long.parseLong(num));
        
        dfs(0, new char[3]);
        
        return answer;
    }
    
    public static void dfs(int depth, char[] p) {
        if(depth == 3) {
            // 원본 ArrayList를 복사한다.
            ArrayList<Long> numsCopy = new ArrayList<>(nums);
            ArrayList<Character> opsCopy = new ArrayList<>(ops);
            
            for(int i=0; i < p.length; i++) {
                for(int j=0; j < opsCopy.size(); j++) {
                    if(p[i] == opsCopy.get(j)) {
                        Long res = calc(numsCopy.remove(j), numsCopy.remove(j), p[i]);
                        numsCopy.add(j, res);
                        opsCopy.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(numsCopy.get(0)));
            return;
        }
        
        // 모든 우선순위 조합
        for(int i=0; i < 3; i++) {
            if(!check[i]) {
                check[i] = true;
                p[depth] = prior[i];
                dfs(depth+1, p);
                check[i] = false;
            }
        }
    } 
    
    
    public static Long calc(Long num1, Long num2, char op) {
        long num = 0;
        switch(op) {
            case '+': {
                return num1 + num2;
            }
            case '-': {
                return num1 - num2;
            }
            case '*': {
                return num1 * num2;
            }
        }
        return num;
    }
}