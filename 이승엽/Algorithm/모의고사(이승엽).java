class Solution {
    public int[] solution(int[] answers) {
        String[] p = {"12345","21232425","3311224455"};
        
        int[] cnt = new int[3];
        
        int max = 0;
        for(int i = 0; i < answers.length; i++){
            for(int j = 0; j < 3; j++){
                if(answers[i] == p[j].charAt(i%p[j].length())-'0'){
                    cnt[j]++;
                    max = Math.max(cnt[j],max);
                }
            }
        }
        
        String ans = "";
        
        for(int i = 0; i < 3; i++){
            if(cnt[i] == max){
                ans+=(i+1);
            }
        }
        
        int[] answer = new int[ans.length()];
        for(int i = 0; i < answer.length;i++){
            answer[i] = (int)(ans.charAt(i)-'0');
        }
        return answer;
    }
}