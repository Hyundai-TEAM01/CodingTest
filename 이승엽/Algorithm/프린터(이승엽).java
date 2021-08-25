import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        ArrayList<Post> list = new ArrayList<>();
        Post check = null;
        for(int i = 0;i < priorities.length; i++){
            list.add(new Post(priorities[i]));
            if(i == location){
                check = list.get(i);
            }
        }
        
        while(!list.isEmpty()){
            int max = max(list);     
            int i = 0;
            while(true){
                if(list.get(i).p < max){
                    Post temp = list.get(i);
                    list.remove(0);
                    list.add(temp);
                    i--;
                }else{
                    if(check == list.get(i)){
                        return answer;
                    }else{
                        list.remove(i);
                        answer++;
                        break;
                    }
                }
                i++;
            }
        }
        return answer;
    }
    
    class Post{
        int p;
        public Post(int p){
            this.p = p;
        }
    }
    
    static int max(ArrayList<Post> li){
        int max = 0;
        for(int i = 0; i < li.size(); i++){
           if(max < li.get(i).p){
               max = li.get(i).p;
           }
        }
        
        return max;
    }
}