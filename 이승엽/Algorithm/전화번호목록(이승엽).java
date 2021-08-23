import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book); // 12 123 124 129 1345 14 
        
        for(int i = 0; i < phone_book.length; i++){
            for(int j = i+1; j < phone_book.length; j++){
                if(phone_book[j].startsWith(phone_book[i])){
                    return false;
                }
                if(phone_book[i].length() > phone_book[j].length() 
                		|| phone_book[i].compareTo(phone_book[j].substring(0,phone_book[i].length())) != 1 ){
                    break;
                }

            }
        }
        
        return answer;
    }
}
/* 기존에 작성한 코드
class Solution {
    public boolean solution(String[] phone_book) {      
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) {
                    answer = false;
                    break;
                }
                if(phone_book[j].length() <= phone_book[i].length()){
                    break;
                }
            }
        }
        
        return answer;
    }
}
*/