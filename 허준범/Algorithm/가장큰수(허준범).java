import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 못 품 승엽님 코드참고 
        // 핵심은 정렬기준! 새로운문자열 = 문자열1+문자열2
        // {0,0,0,0} 인 테스트케이스 11번 고려해야함
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] strNumbers = new String[numbers.length]; 
        
        for(int i=0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return Integer.parseInt(str2+str1) - Integer.parseInt(str1+str2);
            }
        })
        
        for(String strNumber : strNumbers)
            sb.append(strNumber);
        
        if(sb.toString().charAt(0) == '0')
            answer = "0";
        else
            answer = sb.toString();
        
        return answer;
    }
}