import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int day = 0;
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		int temp = 0;
		
		for(int i = 0; i < progresses.length; i++) {
			if(progresses[i] + day*speeds[i] >= 100) {
				temp++;
			}else {
				if(temp != 0) {
					answer.add(temp);
				}
				temp = 1;
				while(progresses[i] + day*speeds[i] < 100) {
					day++;
				}
			}
		}
		
		if(temp != 0) {
			answer.add(temp);
		}
        
        int[] a = new int[answer.size()];
        
        for(int i = 0;i < answer.size();i++){
            a[i] = answer.get(i);
        }

        return a;
    }
}

/* 이전코드
 import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> check = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
            queue.offer(progresses[i]);
            queue.offer(speeds[i]);
        }

        int day = 0;
        while(!queue.isEmpty()){
            int nowP = queue.poll();
            int nowS = queue.poll();
            if(nowP + nowS*day >= 100) {
                list.add(nowP);
                continue;
            }else{
                if(list.size()!=0){
                    check.add(list.size());
                    list.clear();
                }
            }
            while(nowP + nowS*day < 100){
                day++;
            }
            list.add(nowP);
        }
        
        if(list.size() != 0){
            check.add(list.size());
        }
        answer = new int[check.size()];
        for(int i = 0 ; i < check.size(); i++){
            answer[i] = check.get(i);
        }
        
        return answer;
    }
} 
 */
