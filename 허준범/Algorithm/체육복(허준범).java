class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] all = new int[n];
        
        for(int i : reserve) // 여분의 체육복
            all[i-1]++;
        
        for(int i : lost) // 도난당한 체육복
            all[i-1]--;
        
        
        for(int i=0; i < n; i++) {
            if(all[i] < 0) { // 체육복이 없다면
                if(0 <= i - 1 && all[i-1] > 0) {
                    // 인덱스[1 ~ n-1] 범위이면서 이전 학생이 체육복이 있다면, 체육복 빌림
                    all[i]++;
                    all[i-1]--;
                }
                else if(i + 1 < n && all[i+1] > 0) {
                    // 인덱스[0 ~ n-2] 범위이면서 다음 학생이 체육복이 있다면, 체육복 빌림
                    all[i]++;
                    all[i+1]--; 
                }
            }
        }
        
        for(int suit : all) { // 0이상이면 체육복 있다.
            if(suit >= 0)
                answer++;
        }    
        
        return answer;
    }
}