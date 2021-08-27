class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        int top = -1;
        int stack[] = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++){
            if(i == prices.length-1){ // 마지막 값은 항상 0처리 후 종료
                answer[i] = 0;
                break;
            }
            
            if(top == -1){ // stack에 원소가 없을 경우 추가
                top++;
                stack[top] = i;
            }else{
                if(prices[stack[top]] <= prices[i]){ // 다음 값이 더 크거나 같을 경우
                    stack[++top] = i;
                }else{ // 다음 값이 작을 경우
                    while(top > -1 && prices[stack[top]] > prices[i]){ 
                        answer[stack[top]] = (i - stack[top--]);
                    }
                    stack[++top] = i;
                }
            }
        }

        while(top > -1){ // 끝까지 감소하지 않은 값들 처리
            answer[stack[top]] = prices.length - stack[top--] - 1;
        }
        return answer;
    }
}