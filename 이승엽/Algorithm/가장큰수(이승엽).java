import java.util.*;
class Solution {
    public String solution(int[] numbers) {
    
        String[] str = new String[numbers.length];
        
        for(int i = 0; i < str.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                return Integer.parseInt(str2+str1) - Integer.parseInt(str1+str2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str.length; i++){
            sb.append(str[i]);
        }
        
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}

//import java.util.*;
//class Solution {
//    public String solution(int[] numbers) {
//        String[] str = new String[numbers.length];
//        
//        for(int i = 0; i < str.length; i++){
//            str[i] = String.valueOf(numbers[i]);
//        }
//
//        Arrays.sort(str, new Comparator<String>(){
//            @Override
//            public int compare(String s1, String s2){
//                return (s2+s1).compareTo(s1+s2);
//            }
//        });
//
//        String answer = "";
//
//        for(int i = 0 ;i < str.length; i++) {
//            answer += str[i] + "";
//        }
//        
//        if(answer.charAt(0) == '0'){
//            return "0";
//        }
//        
//        
//        return answer;
//    }
//}