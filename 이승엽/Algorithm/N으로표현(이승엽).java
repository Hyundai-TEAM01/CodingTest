import java.util.*;
class Solution {
    public int solution(int N, int number) {

        HashSet<Integer>[] set = new HashSet[9];
        for(int i = 1; i < 9; i++){
            set[i] = new HashSet<Integer>();
        }
        
        set[1].add(N);
        
        if(N == number){
            return 1;
        }
       

        for(int i = 2; i < 9; i++){
            // N을 i번 붙여서 만드는 케이스
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < i; j++){
                sb.append(N);
            }
            int addNum = Integer.parseInt(sb.toString());
           
            if(addNum == number){
                return i;
            }
            set[i].add(addNum);
            
            // 1,1            2개 사용
            // 1,2            3개 사용
            // 2,2 1,3        4개 사용
            // 1,4 2,3        5개 사용
            // 1,5, 2,4, 3,3   6개 사용
            for(int j = 1; j <= i/2; j++){
                Iterator iter1 = set[i-j].iterator();
                // 기존에 만들어진 수에 사칙 연산 추가
                while(iter1.hasNext()){
                    int now = (int)iter1.next();
                    Iterator iter2 = set[j].iterator();
                    while(iter2.hasNext()){
                        int now2 = (int)iter2.next();
                        set[i].add(now+now2);
                        set[i].add(now*now2);
                        if(now2 != 0)
                            set[i].add(now/now2);
                        set[i].add(now-now2);
                        

                        if(now != 0)
                            set[i].add(now2/now);
                        set[i].add(now2-now);
                        
                    }
                }
                if(set[i].contains(number)){
                    return i;
                }
            }
        }
        

        
        return -1;
    }
}