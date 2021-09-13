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
            } else {
                left++;
                right--;
            }
            if(left == right){
                answer++;
            }
            answer++;
        }
        return answer;
    }
}


// import java.util.*;

// class Solution {
//     public int solution(int[] people, int limit) {
//         ArrayList<Integer> peoples = new ArrayList<>();
//         int answer = 0;
//         int left = 0;
//         int right = people.length - 1;
//         Arrays.sort(people);
        
//         for(int i = 0; i < people.length; i++){
//             peoples.add(people[i]);
//         }
//         // System.out.println(peoples);
        
//         // 정렬후
//         // 투포인터 left, right
//         // left는 움직이지않고.
//         // right는 가져와서 left + right < 100 인 경우에 같이빼준다.
//         // right에서 부터 다음 left를 찾아 left + right 해준다.
        
        
//         int i = 0;
//         while(true){
//             if(i >= right){
//                 System.out.println("i 와 j가 같다. 탈출");
//                 break;
//             }
//             for(int j = right; j > i; j--){
//                 System.out.println(i + " 와 " + j + " 비교");
//                 if(i == j){
//                     System.out.println("돌다가 i와 j가 같아졌다. 삭제 : " + peoples.get(i));
//                     peoples.remove(i);
//                     answer++;
//                     right--;
//                     break;
//                 }
//                 if(peoples.get(i) + peoples.get(j) > limit){
//                     right--;
//                 } else{
//                     System.out.println("둘의 합이 limit 보다 작다" + peoples.get(i) + " " + peoples.get(j));
//                     peoples.remove(i);
//                     peoples.remove(j-1);
//                     right -= 2;
//                     answer++;
//                     break;
//                 }
//             }
//         }
//         System.out.println(peoples.size());
//         answer += peoples.size();
        
        
//         return answer;
//     }
// }
