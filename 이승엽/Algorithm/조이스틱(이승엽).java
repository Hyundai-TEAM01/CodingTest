import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int[] arr = new int[n];
       
        
        int max, temp;
        max = temp = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);
            answer += arr[i];
            if(arr[i] == 0){
                temp++;
            }else{
                max = Math.max(max,temp);
                temp = 0;
            }
        }
        
        if(max == 0){ // A가 하나도 없는 경우
            answer += n-1;
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < max; i++){
                sb.append("A");
            }
            int idx = name.indexOf(sb.toString()); // 가장 긴 연속된 A의 시작점
            
            //BBAB AAAAAAA BB
            //    idx
            //(idx-2)*2 = BBA 왕복
            // +1 = B에 한번 가는
            if(n-1 > (idx-1)*2+(n-(idx+max))){
                answer+= (idx-1)*2+(n-(idx+max));
            }else{
                answer += n-1;
            }
            
        }

        
        System.out.println(Arrays.toString(arr));
        
        return answer;
    }
}