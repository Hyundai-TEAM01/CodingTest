class Solution {
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        int comp = 0;
        for (int i = 0; i < number.length()-k; i++){
            comp = 0;
            for(int j = idx; j <= i+k; j++){
                if(comp < number.charAt(j) - '0'){
                    comp = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }
            sb.append(comp);
        }
        return sb.toString();
    }
}
// 참고 : https://jhhj424.tistory.com/32
