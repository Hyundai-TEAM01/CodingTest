import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        ArrayList<Integer> peoples = new ArrayList<>();
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);
        
        for(int i = 0; i < people.length; i++){
            peoples.add(people[i]);
        }
        
        while (left < right){
            if(peoples.get(left) + peoples.get(right) > limit){
                right--;
                if(left == right){
                    answer++;
                }
            } else {
                left++;
                right--;
                if(left == right){
                    answer++;
                }
            }
            answer++;
        }
        return answer;
    }
}
