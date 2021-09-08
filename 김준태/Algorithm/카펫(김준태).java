class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int brHeight = 3;
        int brWidth = 3;
        
        int yeHeight = 0;
        int yeWidth = 0;
        
        while(true){
            yeHeight = brHeight - 2;
            yeWidth = (brown - (brHeight * 2)) / 2;
            brWidth = yeWidth + 2;
            if (yellow == yeHeight * yeWidth){
                break;
            }
            brHeight++;
        }
        answer[0] = brWidth;
        answer[1] = brHeight;
        return answer;
    }
}
