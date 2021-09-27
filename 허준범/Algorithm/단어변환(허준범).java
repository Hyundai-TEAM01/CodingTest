class Solution {
    
    public static int result = 51; // words에 최대 값은 50개 이하
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        if(!ispossible(target, words)) // 변환할 수 없는 경우
            return 0;
        
        int len = begin.length();
        boolean[] visited = new boolean[words.length];
        change(0, len, begin, target, words, visited);
        
        answer = result;
        
        return answer;
    }
    
    // words에 target 값이 없는 경우
    public static boolean ispossible(String target, String[] words) {
        for(int i=0; i < words.length; i++) {
            if(words[i].equals(target))
                return true;
        }
        return false;
    }
    
    public static void change(int depth, int len, String begin, String target, String[] words, boolean[] visited) {
        // begin이 target하고 같아진 경우 result 최솟값 비교
        if(begin.equals(target)) {
            result = Math.min(result, depth);
            return;
        }
        
        // words에서 방문하지 않은 것 중에 문자가 한 개 차이나는 것을 찾는다.
        for(int i=0; i < words.length; i++) {
            if(!visited[i]) {
                int count = 0;
                for(int j=0; j < len; j++) {
                if(begin.charAt(j) != words[i].charAt(j))
                    count++;
                }
                if(count == 1) {
                    visited[i] = true;
                    begin = words[i]; // 찾은 문자로 begin을 바꾼다.
                    change(depth+1, len, begin, target, words, visited);
                }
            }            
        }
    }
    
}