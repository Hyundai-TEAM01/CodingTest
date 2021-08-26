import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        		Deque<Integer> q = new ArrayDeque<>();
		int answer = 0;
		int nowWeight = 0;
		int idx = 0;
		int dumy = 10001;

		while (true) {
			while (idx < truck_weights.length && q.size() < bridge_length && nowWeight + truck_weights[idx] <= weight) {
				nowWeight += truck_weights[idx];
				q.add(idx++);
				answer += 1;
			}

			if (q.size() == bridge_length) {
				if (q.peekFirst() != dumy) {
					nowWeight -= truck_weights[q.pollFirst()];
				}else {
					q.pollFirst();
				}
			} else if (idx == truck_weights.length) {
				answer += bridge_length;
				break;
			} else { // 무게 제한
				while(q.size() < bridge_length) {
					q.add(dumy);
					answer++;
				}

				if(q.peekFirst() != dumy)
					nowWeight -= truck_weights[q.pollFirst()];
				else
					q.pollFirst();
			}

		}
        return answer;
    }
}