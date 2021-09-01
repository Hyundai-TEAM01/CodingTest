import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int length = numbers.length;
        ArrayList<String> strNumbers = new ArrayList<>();
        
        for (int num : numbers){
            strNumbers.add(String.valueOf(num));
        }
        
        Collections.sort(strNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if(strNumbers.get(0).startsWith("0")){
            return "0";
        }
        for (String num : strNumbers){
            answer += num;
        }
        
//         String[] strNumbers = new String[numbers.length];
        
//         for(int i = 0; i < length; i++){
//             strNumbers[i] = String.valueOf(numbers[i]);
//         }
        
//         Arrays.sort(strNumbers, new Comparator<String>(){
//             @Override
//             public int compare(String o1, String o2){
//                 return (o2 + o1).compareTo(o1+o2);
//             }
//         });
        
//         if (strNumbers[0].startsWith("0")) {
//             answer += "0";
//         } else {
//             for(int i = 0; i < strNumbers.length; i++){
//                 answer += strNumbers[i];
//             }
//         }
        return answer;
    }
} 
