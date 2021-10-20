class Solution {
    public int cnt;
    public String[] friends = {"A","C", "F", "J", "M", "N", "R", "T"};
    public boolean[] visited = new boolean[8];
    
    public int solution(int n, String[] data) {
        int answer = 0;
        dfs("", data);
        answer = cnt;
        return answer;
    }
    
    public void dfs(String names, String[] data) {
        if(names.length() == friends.length) {
            if(ispossible(names, data))
                cnt++;
            return;
        }
        
        for(int i=0; i < friends.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                // "A" + "C" ...
                dfs(names + friends[i], data);
                visited[i] = false;
            }
        }
    }
    
    public boolean ispossible(String names, String[] data) {
        for(int i=0; i < data.length; i++) {
            int pos1 = names.indexOf(data[i].charAt(0)); // 프렌즈 포지션1
            int pos2 = names.indexOf(data[i].charAt(2)); // 프렌즈 포지션1
            char op = data[i].charAt(3); // 수식
            int idx = data[i].charAt(4) - '0'; // 간격
            if(op == '=') {
                if(!(Math.abs(pos1 - pos2) == idx+1)) return false;
            } else if(op == '>') {
                if(!(Math.abs(pos1 - pos2) > idx+1)) return false;
            } else if(op == '<') {
                if(!(Math.abs(pos1 - pos2) < idx+1)) return false;
            }
        }
        return true;
    }
}