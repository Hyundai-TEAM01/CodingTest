import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
              
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < commands.length; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int index = commands[i][2]-1;
            int[] temp = Arrays.copyOfRange(array, start, end);
            Arrays.sort(temp);
            
            list.add(temp[index]);
        }
        
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}
