import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int size = 0;
        int lastSize = triangle[triangle.length-1].length;
        
        for(int i = 1; i <= lastSize; i++){
            size+= i;
        }
        
        int[] arr = new int[size+1];
        arr[1] = triangle[0][0];
        int idx = 2;
        for(int i = 1; i < triangle.length;i++){
            int nowSize = triangle[i].length;
            for(int j = 0; j < nowSize;j++){
                if(j == 0){ // 처음 , 부모 선택
                     arr[idx+j] = arr[idx-(nowSize-1)]+triangle[i][j];
                }else if(j == nowSize-1){ // 마지막, 부모선택
                    arr[idx+j] = arr[idx-1]+triangle[i][j];
                }
                else{
                     int parent = Math.max(arr[idx-triangle[i-1].length-1+j],arr[idx-triangle[i-1].length+j]);
                    
                    //왼쪽 부모
                    //idx-triangle[i-1].size-1+j // 이전 시작점
                    // 오른쪽 부모
                    //idx-triangle[i-1].size+j
                    // 5 - 2,3    idx = 4     j =1
                    
                    // 8 - 4,5    idx = 7     j = 1
                    // 9 - 5,6    idx = 7    j = 2
                    
                    // 12 - 7,8    idx = 11   j = 1
                    // 13 - 8,9     idx = 11  j = 2
                    // 14 - 10,11   idx = 11  j = 3
                     arr[idx+j] = triangle[i][j] + parent;
                }
                
            }
            idx += nowSize;
        }
        
        for(int i = size - lastSize; i < arr.length; i++){
            answer = Math.max(answer,arr[i]);   
        }
  

        return answer;
    }
}